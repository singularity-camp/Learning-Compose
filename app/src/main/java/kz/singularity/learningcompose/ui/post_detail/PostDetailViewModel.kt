package kz.singularity.learningcompose.ui.post_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.models.Post
import kz.singularity.domain.use_cases.GetPostCommentsUseCase
import kz.singularity.domain.use_cases.GetPostDetailsUseCase
import kz.singularity.domain.use_cases.GetUserByIdUseCase
import kz.singularity.learningcompose.models.PostUI

class PostDetailViewModel(
    private val post: PostUI,
    private val getPostCommentsUseCase: GetPostCommentsUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase
) : ViewModel() {


    private val _screenState = mutableStateOf(
        PostDetailState(
            title = post.title,
            body = post.body,
            userName = null,
            comments = emptyList()
        )
    )
    val screenState: State<PostDetailState> = _screenState

    init {
        getUser()
        getComments()
    }


    private fun getUser() {
        viewModelScope.launch {
            val user = getUserByIdUseCase(post.userId)
            val curState = _screenState.value
            _screenState.value = curState.copy(userName = user.name)
        }
    }

    private fun getComments() {
        viewModelScope.launch {
            val comments = getPostCommentsUseCase(post.id)
            val curState = _screenState.value
            _screenState.value = curState.copy(comments = comments)
        }
    }

}