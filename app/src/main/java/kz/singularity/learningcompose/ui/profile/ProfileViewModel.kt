package kz.singularity.learningcompose.ui.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.use_cases.GetUserByIdUseCase

class ProfileViewModel(
    private val getUserByIdUseCase: GetUserByIdUseCase
) : ViewModel() {

    private val initial = ProfileScreenState.Initial

    private val _screenState = mutableStateOf<ProfileScreenState>(initial)
    val screenState: State<ProfileScreenState> = _screenState

    init {
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch {
            val user = getUserByIdUseCase(1)
            _screenState.value = ProfileScreenState.Profile(user)
        }
    }
}