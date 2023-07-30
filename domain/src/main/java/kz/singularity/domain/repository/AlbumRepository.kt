package kz.singularity.domain.repository

import kz.singularity.domain.models.Album
import kz.singularity.domain.models.Photo

interface AlbumRepository {

    suspend fun getAlbums():List<Album>

    suspend fun getPhotosByAlbumId(albumId:Long):List<Photo>
}