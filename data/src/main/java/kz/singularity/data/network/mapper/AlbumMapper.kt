package kz.singularity.data.network.mapper

import com.example.dependencyinjection.data.db.room.entity.AlbumEntity
import kz.singularity.data.db.room.entity.PostEntity
import kz.singularity.data.network.response.AlbumResponse
import kz.singularity.domain.models.Album
import kz.singularity.domain.models.Post

class AlbumMapper {
    fun fromRemoteToDomain(albumResponse: AlbumResponse): kz.singularity.domain.models.Album {
        return kz.singularity.domain.models.Album(
            id = albumResponse.id,
            userId = albumResponse.userId,
            title = albumResponse.title

        )
    }
    fun fromEntityToDomain(entity: AlbumEntity): kz.singularity.domain.models.Album {
        return kz.singularity.domain.models.Album(
            id = entity.id,
            title = entity.title,
            userId = entity.userId
        )
    }
    fun fromDomainToEntity(album: Album): AlbumEntity {
        return AlbumEntity(
            id = album.id,
            title = album.title,
            userId = album.userId
        )
    }

}