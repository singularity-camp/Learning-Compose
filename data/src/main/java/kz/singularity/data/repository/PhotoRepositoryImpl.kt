package kz.singularity.data.repository


import kz.singularity.data.network.api.PlaceholderService
import kz.singularity.data.network.mapper.PhotoMapper
import kz.singularity.domain.models.Photo
import kz.singularity.domain.repository.PhotoRepository

class PhotoRepositoryImpl(
    private val placeholderService: PlaceholderService,
    private val mapper: PhotoMapper,
    ) : PhotoRepository {

    override suspend fun getPhotos(): List<Photo> {
        val photoResponses = placeholderService.getPhotos()
        return photoResponses.map { mapper.fromRemoteToDomain(it) }
    }

    override suspend fun getPhotosFromAlbum(albumId: Long): List<Photo> {
        val responce = placeholderService.getPhotosFromAlbum(albumId)
        return responce.map { mapper.fromRemoteToDomain(it) }
    }

    override suspend fun getPhoto(photoId: Long): Photo {
        val response = placeholderService.getPhotoDetails(photoId)
        return mapper.fromRemoteToDomain(response)
    }


}