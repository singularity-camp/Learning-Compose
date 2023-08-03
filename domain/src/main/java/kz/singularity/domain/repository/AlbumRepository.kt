package kz.singularity.domain.repository

import kz.singularity.domain.models.Album

interface AlbumRepository {
    suspend fun getAlbums(): List<Album>
}