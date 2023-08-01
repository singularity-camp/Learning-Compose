package kz.singularity.data.network.mapper

import kz.singularity.data.network.response.AlbumResponse
import kz.singularity.domain.models.Album

internal class AlbumMapper {

    fun fromRemoteToDomain(albumResponse: AlbumResponse):Album{
        return Album(
            id = albumResponse.id,
            title = albumResponse.title,
            userId = albumResponse.userId
        )
    }
}