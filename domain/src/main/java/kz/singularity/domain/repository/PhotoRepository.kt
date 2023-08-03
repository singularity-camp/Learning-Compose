package kz.singularity.domain.repository

import kz.singularity.domain.models.Album
import kz.singularity.domain.models.Photo

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
    suspend fun getPhotosFromAlbum(albumId: Long): List<Photo>
    suspend fun getPhoto(photoId: Long): Photo
}