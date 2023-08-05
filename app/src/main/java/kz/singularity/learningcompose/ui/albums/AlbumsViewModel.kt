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

class AlbumsViewModel(
    private val getAlbumsUseCase: GetAlbumsUseCase,
    private val getPhotosUseCase: GetPhotosUseCase,
    private val getUsersUseCase: GetUsersUseCase
):ViewModel() {

    private val _albums = mutableStateListOf<Album>()
    val album: SnapshotStateList<Album> = _albums

    private val _photos = mutableStateListOf<Photo>()
    private val _users = mutableStateListOf<User>()

    private val _albumIdToUsernameMap = mutableStateMapOf<Long, String>()
    val albumIdToUsernameMap: SnapshotStateMap<Long, String> = _albumIdToUsernameMap

    private val _albumIdToFirstPhotoMap = mutableStateMapOf<Long, Photo?>()
    val albumIdToFirstPhotoMap: SnapshotStateMap<Long, Photo?> = _albumIdToFirstPhotoMap

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> get() = _isLoading

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                _photos.addAll(getPhotosUseCase())
                _albums.addAll(getAlbumsUseCase())
                _users.addAll(getUsersUseCase())

                _albums.forEach { album ->
                    val user = _users.find { it.id.toLong() == album.userId }
                    if (user != null) {
                        _albumIdToUsernameMap[album.id] = user.username
                    }

                    val photosForAlbum = _photos.filter { it.albumId == album.id }
                    _albumIdToFirstPhotoMap[album.id] = photosForAlbum.firstOrNull()
                }

                _isLoading.value = false
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching data: ${e.message}")
                _isLoading.value = false // Set isLoading to false on error as well
            }
        }
    }
}