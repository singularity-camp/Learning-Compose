package kz.singularity.data.repository

import kz.singularity.data.network.api.PlaceholderService
import kz.singularity.data.network.mapper.AlbumMapper
import kz.singularity.data.network.mapper.PhotoMapper
import kz.singularity.domain.models.Album
import kz.singularity.domain.models.Photo
import kz.singularity.domain.repository.AlbumRepository

internal class AlbumRepositoryImpl(
    private val placeholderService: PlaceholderService,
    private val albumMapper: AlbumMapper,
    private val photoMapper: PhotoMapper
):AlbumRepository {
    override suspend fun getAlbums(): List<Album> {
        val response = placeholderService.getAlbums()
        return response.map { albumMapper.fromRemoteToDomain(it) }
    }

    override suspend fun getPhotosByAlbumId(albumId: Long): List<Photo> {
        val response = placeholderService.getPhotosByAlbumId(albumId)
        return response.map { photoMapper.fromRemoteToDomain(it) }
    }
}