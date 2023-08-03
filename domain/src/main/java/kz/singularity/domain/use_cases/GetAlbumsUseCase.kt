package kz.singularity.domain.use_cases

import kz.singularity.domain.models.Album
import kz.singularity.domain.repository.AlbumRepository

class GetAlbumsUseCase(private val repository: AlbumRepository) {
    suspend operator fun invoke(): List<Album>{
        return repository.getAlbums()
    }
}