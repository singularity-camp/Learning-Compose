package kz.singularity.learningcompose.ui.user_profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.use_cases.GetUserByIdUseCase

class UserProfileViewModel(
    private val userId: Long,
    private val getUserByIdUseCase: GetUserByIdUseCase
) : ViewModel() {
    private val initial = UserProfileScreenState.Initial

    private val _screenState = mutableStateOf<UserProfileScreenState>(initial)
    val screenState: State<UserProfileScreenState> = _screenState

    init {
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch {
            val user = getUserByIdUseCase(userId)
            _screenState.value = UserProfileScreenState.Profile(user)
        }
    }
}