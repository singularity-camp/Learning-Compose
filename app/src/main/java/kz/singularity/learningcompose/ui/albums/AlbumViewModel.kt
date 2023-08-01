package kz.singularity.learningcompose.ui.albums

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.models.Album
import kz.singularity.domain.use_cases.GetAlbumsUseCase
import kz.singularity.domain.use_cases.GetUserByIdUseCase
import kz.singularity.learningcompose.models.AlbumUI

class AlbumViewModel(
    private val getAlbumsUseCase: GetAlbumsUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase
) : ViewModel() {

    private val _screenState = mutableStateOf<List<AlbumUI>>(emptyList())
    val screenState: State<List<AlbumUI>> = _screenState

    init {
        getAlbums()
    }


    private fun getAlbums() {
        viewModelScope.launch {
            val albums = getAlbumsUseCase()
            _screenState.value = albums.map {
                AlbumUI(
                    id = it.id,
                    imgUrl = "",
                    name = it.title,
                    userName = ""
                )
            }
            albums.forEachIndexed { index, album ->
                launch {
                    val user = getUserByIdUseCase(album.userId)
                    val albums = _screenState.value.toMutableList()
                    val oldAlbum = albums[index]
                    val newAlbum = oldAlbum.copy(userName = user.name)
                    albums[index] = newAlbum
                    _screenState.value = albums.toList()
                }
            }
        }
    }


}