package kz.singularity.learningcompose.ui.comments

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.models.Comment
import kz.singularity.domain.use_cases.GetCommentsUseCase

class CommentsViewModel(
    private val getCommentUseCase:GetCommentsUseCase
):ViewModel() {

    private val _screenState = mutableStateOf<List<Comment>>(emptyList())
    val screenState: State<List<Comment>> = _screenState

    init {
        getComments()
    }

    private fun getComments(){
        viewModelScope.launch {
            val comments = getCommentUseCase()
            _screenState.value = comments
        }
    }
}