package kz.singularity.domain.use_cases

import kz.singularity.domain.repository.AlbumRepository

class GetPhotosByAlbumIdUseCase(
    private val repository: AlbumRepository
) {
    suspend operator fun invoke(albumId:Long) = repository.getPhotosByAlbumId(albumId)
}