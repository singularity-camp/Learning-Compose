package kz.singularity.learningcompose.ui.albums

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.models.Album
import kz.singularity.domain.models.Photo
import kz.singularity.domain.models.User
import kz.singularity.domain.use_cases.GetAlbumsUseCase
import kz.singularity.domain.use_cases.GetPhotosUseCase
import kz.singularity.domain.use_cases.GetUsersUseCase

class PhotoViewModel(
    private val getAlbumsUseCase: GetAlbumsUseCase,
    private val getPhotosUseCase: GetPhotosUseCase,
):ViewModel() {

    private val _albums = mutableStateListOf<Album>()
    private val _photos = mutableStateListOf<Photo>()

    private val _albumIdToPhotosMap = mutableStateMapOf<Long, List<Photo>>()
    val albumIdToPhotosMap: SnapshotStateMap<Long, List<Photo>> = _albumIdToPhotosMap

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> get() = _isLoading

    enum class ViewMode {
        List,
        Grid
    }

    private val _viewMode = mutableStateOf(ViewMode.List)
    val viewMode: ViewMode
        get() = _viewMode.value

    fun toggleViewMode() {
        _viewMode.value = when (_viewMode.value) {
            ViewMode.List -> ViewMode.Grid
            ViewMode.Grid -> ViewMode.List
        }
    }

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                _photos.addAll(getPhotosUseCase())
                _albums.addAll(getAlbumsUseCase())

                _albums.forEach { album ->
                    val photosForAlbum = _photos.filter { it.albumId == album.id }
                    _albumIdToPhotosMap[album.id] = photosForAlbum

                }

                _isLoading.value = false
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching data: ${e.message}")
                _isLoading.value = false // Set isLoading to false on error as well
            }
        }
    }
}