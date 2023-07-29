package kz.singularity.learningcompose.ui.main

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.models.Post
import kz.singularity.domain.use_cases.GetPostDetailsUseCase
import kz.singularity.domain.use_cases.GetPostsUseCase
import kz.singularity.learningcompose.models.PostUI

class MainViewModel(
    private val getPostsUseCase: GetPostsUseCase,
    private val getPostDetailsUseCase: GetPostDetailsUseCase,
) : ViewModel() {

    private val _posts = mutableStateListOf<PostUI>()
    val posts: SnapshotStateList<PostUI> = _posts

    init {
        viewModelScope.launch {
            val posts = getPostsUseCase()
            _posts.addAll(posts.map { domainToUi(it) })
        }
    }

    private fun domainToUi(post: Post) = PostUI(
        body = post.body,
        id = post.id,
        title = post.title,
        userId = post.userId
    )

    fun onPostClick(postId: Long) {
        viewModelScope.launch {
            Log.e("TAG", getPostDetailsUseCase(postId).toString())
        }
    }
}