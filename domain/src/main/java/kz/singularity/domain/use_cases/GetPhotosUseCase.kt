package kz.singularity.domain.use_cases

import kz.singularity.domain.models.Album
import kz.singularity.domain.models.Photo
import kz.singularity.domain.repository.AlbumRepository
import kz.singularity.domain.repository.PhotoRepository

class GetPhotosUseCase(private val repository: PhotoRepository) {
    suspend operator fun invoke(): List<Photo>{
        return repository.getPhotos()
    }

    suspend operator fun invoke(albumId: Long): List<Photo>{
        return repository.getPhotosFromAlbum(albumId)
    }

    suspend fun getFirstPhoto(photoId: Long): Photo {
        return repository.getPhoto(photoId)
    }

}