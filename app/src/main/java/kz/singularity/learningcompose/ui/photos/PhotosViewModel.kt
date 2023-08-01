package kz.singularity.learningcompose.ui.photos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.use_cases.GetPhotosByAlbumIdUseCase
import kz.singularity.learningcompose.models.AlbumUI

class PhotosViewModel(
    private val album: AlbumUI,
    private val getPhotosByAlbumIdUseCase: GetPhotosByAlbumIdUseCase
) : ViewModel() {

   private val _screenState = mutableStateOf<PhotosScreenState>(PhotosScreenState.Initial)
    val screenState: State<PhotosScreenState> = _screenState

    init {
        getPhotos()
    }

    fun changeState(){
        val curState = _screenState.value
        if (curState !is PhotosScreenState.Photos) return
        _screenState.value = curState.copy(isGrid = !curState.isGrid)
    }

    private fun getPhotos() {
        viewModelScope.launch {
            val photos = getPhotosByAlbumIdUseCase(album.id)
            _screenState.value = PhotosScreenState.Photos(
                photos = photos,
                albumName = album.name,
                userName = album.userName
            )
        }
    }
}