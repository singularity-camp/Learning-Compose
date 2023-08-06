package kz.singularity.learningcompose.ui.posts

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.models.Comment
import kz.singularity.domain.models.Post
import kz.singularity.domain.use_cases.GetCommentsUseCase
import kz.singularity.domain.use_cases.GetUsersUseCase

class PostDetailedViewModel(
    private val getPostsUseCase: kz.singularity.domain.use_cases.GetPostsUseCase,
    private val getCommentsUseCase: GetCommentsUseCase,
) : ViewModel() {

    private val _posts = mutableStateListOf<kz.singularity.domain.models.Post>()

    private val _commentsMap = mutableStateMapOf<Long, List<Comment>>()
    val commentsMap: SnapshotStateMap<Long, List<Comment>> = _commentsMap

    private val _postsMap = mutableStateMapOf<Long, Post>()
    val postsMap: SnapshotStateMap<Long, Post> = _postsMap

    init {
        viewModelScope.launch {
            val posts = getPostsUseCase()
            _posts.addAll(posts)

            posts.forEach { post ->
                _postsMap[post.id] = post
                getCommentFromPost(post.id)
            }
        }
    }

    private fun getCommentFromPost(postId: Long) {
        viewModelScope.launch {
            val commentsFromPost = getCommentsUseCase(postId)
            _commentsMap[postId] = commentsFromPost
        }
    }
}