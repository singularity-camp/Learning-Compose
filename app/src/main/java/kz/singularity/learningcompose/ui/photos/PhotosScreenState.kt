package kz.singularity.learningcompose.ui.photos

import kz.singularity.domain.models.Photo

sealed class PhotosScreenState {
    object Initial : PhotosScreenState()
    object Loading : PhotosScreenState()

    data class Photos(
        val isGrid: Boolean = false,
        val photos: List<Photo>,
        val albumName:String,
        val userName:String
    ) : PhotosScreenState()
}
