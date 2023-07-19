package kz.singularity.learningcompose.ui.main

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val getPostsUseCase: kz.singularity.domain.use_cases.GetPostsUseCase,
    private val getPostDetailsUseCase: kz.singularity.domain.use_cases.GetPostDetailsUseCase,
) : ViewModel() {

    private val _posts = mutableStateListOf<kz.singularity.domain.models.Post>()
    val posts: SnapshotStateList<kz.singularity.domain.models.Post> = _posts

    init {
        viewModelScope.launch {
            _posts.addAll(getPostsUseCase())
        }
    }

    fun onPostClick(postId: Long) {
        viewModelScope.launch {
            Log.e("TAG", getPostDetailsUseCase(postId).toString())
        }
    }
}