package kz.singularity.learningcompose.ui.albums

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
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

    private val _photosFromAlbum = mutableStateListOf<Photo>()
    val photosFromAlbum: SnapshotStateList<Photo> = _photosFromAlbum

    private val _users = mutableStateListOf<User>()
    val user: SnapshotStateList<User> = _users

    init {
        viewModelScope.launch {
            _photos.addAll(getPhotosUseCase())
            _albums.addAll(getAlbumsUseCase())
            _users.addAll(getUsersUseCase())
        }
    }

    fun getUserById(userId: Long): User? {
        return user.find { it.id.toLong() == userId }
    }

    fun getPhotoFromList(albumId: Long): Photo? {
        return _photos.find {(it.albumId == albumId)}
    }

    fun getPhotosFromAlbum(albumId: Long){
        viewModelScope.launch{
            _photosFromAlbum.clear()
            val photos = getPhotosUseCase.invoke(albumId)
            _photosFromAlbum.addAll(photos)
        }
    }


   /* private val _firstPhotoMap = mutableStateMapOf<Long, String>()
    val firstPhotoMap: SnapshotStateMap<Long, String> = _firstPhotoMap

    fun getFirstPhoto(albumId: Long) {
        viewModelScope.launch {
            val photo = getPhotosUseCase.getFirstPhoto(1)
            _firstPhotoMap[albumId] = photo.url
        }
    }

    private val _NamesMap = mutableStateMapOf<Long, String>()
    val namesMap: SnapshotStateMap<Long, String> = _NamesMap

    fun getUsersNames(userId: Long) {
        viewModelScope.launch {
            _NamesMap.clear()
            val user = getUsersUseCase(userId)
            _NamesMap[userId] = user.name
        }
    }*/
}