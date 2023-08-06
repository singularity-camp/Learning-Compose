package kz.singularity.learningcompose.ui.posts

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
import kz.singularity.domain.models.User
import kz.singularity.domain.use_cases.GetUsersUseCase

class PostsPageViewModel(
    private val getPostsUseCase: kz.singularity.domain.use_cases.GetPostsUseCase,
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {

    private val _posts = mutableStateListOf<kz.singularity.domain.models.Post>()
    val posts: SnapshotStateList<kz.singularity.domain.models.Post> = _posts

    private val _usersNamesMap = mutableStateMapOf<Long, String>()
    val usersNamesMap: SnapshotStateMap<Long, String> = _usersNamesMap

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> get() = _isLoading

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                val posts = getPostsUseCase()
                _posts.addAll(posts)

                posts.forEach{
                    getUsersNames(it.userId)
                }

                _isLoading.value = false
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching data: ${e.message}")
                _isLoading.value = false // Set isLoading to false on error as well
            }
        }
    }

    private fun getUsersNames(userId: Long) {
        viewModelScope.launch {
            val user = getUsersUseCase(userId)
            _usersNamesMap[userId] = user.name
        }
    }

}