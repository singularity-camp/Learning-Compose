package kz.singularity.data.network.mapper

import kz.singularity.data.network.response.PhotoResponse
import kz.singularity.domain.models.Photo

internal class PhotoMapper {

    fun fromRemoteToDomain(photoResponse:PhotoResponse): Photo {
        return Photo(
            albumId = photoResponse.albumId,
            id = photoResponse.id,
            thumbnailUrl = photoResponse.thumbnailUrl,
            title = photoResponse.title,
            url = photoResponse.url
        )
    }
}