package kz.singularity.data.network.mapper

import kz.singularity.data.network.response.AlbumResponse
import kz.singularity.data.network.response.PhotoResponse

class PhotoMapper {
    fun fromRemoteToDomain(response: PhotoResponse): kz.singularity.domain.models.Photo {
        return kz.singularity.domain.models.Photo(
            id = response.id,
            albumId = response.albumId,
            thumbnailUrl = response.thumbnailUrl,
            title = response.title,
            url = response.url
        )
    }
}