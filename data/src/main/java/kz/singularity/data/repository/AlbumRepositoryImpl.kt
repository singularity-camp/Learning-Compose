package kz.singularity.data.repository


import kz.singularity.data.db.room.dao.AlbumDao
import kz.singularity.data.network.api.PlaceholderService
import kz.singularity.data.network.mapper.AlbumMapper
import kz.singularity.domain.models.Album
import kz.singularity.domain.repository.AlbumRepository

class AlbumRepositoryImpl(
    private val placeholderService: PlaceholderService,
    private val albumMapper: AlbumMapper,
    private val albumDao: AlbumDao

    ) : AlbumRepository {

    val cache = mutableListOf<Album>()

    override suspend fun getAlbums(): List<Album> {

        if (cache.isNotEmpty()) {
            return cache
        }

        val entities = albumDao.getAllAlbums()
        if (entities.isNotEmpty()) {
            val albums = entities.map { entity -> albumMapper.fromEntityToDomain(entity) }
            cache.addAll(albums)

            return albums
        }

        val remoteAlbums = placeholderService.getAlbums()
        val albums = remoteAlbums.map { response -> albumMapper.fromRemoteToDomain(response) }
        cache.addAll(albums)

        val entitiesToStore = albums.map { album -> albumMapper.fromDomainToEntity(album) }
        albumDao.addAlbums(entitiesToStore)
        return albums
    }


   /* override suspend fun getAlbums(): List<Album> {
        val albumResponses = placeholderService.getAlbums()
        return albumResponses.map { albumMapper.fromRemoteToDomain(it) }
    }
*/
}