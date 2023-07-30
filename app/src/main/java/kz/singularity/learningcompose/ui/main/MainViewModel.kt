package kz.singularity.learningcompose.ui.main

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.models.Comment
import kz.singularity.domain.models.Post
import kz.singularity.domain.models.User
import kz.singularity.domain.use_cases.GetCommentsUseCase
import kz.singularity.domain.use_cases.GetUsersUseCase

class MainViewModel(
    private val getPostsUseCase: kz.singularity.domain.use_cases.GetPostsUseCase,
    private val getPostDetailsUseCase: kz.singularity.domain.use_cases.GetPostDetailsUseCase,
    private val getCommentsUseCase: GetCommentsUseCase,
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _posts = mutableStateListOf<kz.singularity.domain.models.Post>()
    val posts: SnapshotStateList<kz.singularity.domain.models.Post> = _posts

    private val _comments = mutableStateListOf<Comment>()
    val comment: SnapshotStateList<Comment> = _comments

    private val _users = mutableStateListOf<User>()
    val user: SnapshotStateList<User> = _users

    init {
        viewModelScope.launch {
            _posts.addAll(getPostsUseCase())
            _comments.addAll(getCommentsUseCase())
            _users.addAll(getUsersUseCase())
        }
    }

    fun onPostClick(postId: Long) {
        viewModelScope.launch {
            Log.e("TAG", getPostDetailsUseCase(postId).toString())
        }
    }

    /*private val _username = mutableStateOf("")
    val username: State<String> = _username

    fun getUsername(userId: Long) {
        viewModelScope.launch {
            val user = getUsersUseCase(userId)
            _username.value = user.username
        }
    }*/

    private val _usersNamesMap = mutableStateMapOf<Long, String>()
    val usersNamesMap: SnapshotStateMap<Long, String> = _usersNamesMap

    fun getUsersNames(userId: Long) {
        viewModelScope.launch {
            val user = getUsersUseCase(userId)
            _usersNamesMap[userId] = user.name
        }
    }

    fun getPostByPageId(postId: Long): Post? {
        return posts.find { it.id == postId }
    }

    private val _commentsFromPost = mutableStateListOf<Comment>()
    val commentFromPost: SnapshotStateList<Comment> = _commentsFromPost
    fun getCommentFromPost(postId: Long) {
        viewModelScope.launch {
            _commentsFromPost.addAll(getCommentsUseCase(postId = postId))
        }
    }


}