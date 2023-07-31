package kz.singularity.learningcompose.ui.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.models.User
import kz.singularity.domain.use_cases.GetUsersUseCase

class UsersViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _screenState = mutableStateOf<List<User>>(emptyList())
    val screenState: State<List<User>> = _screenState

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            val users = getUsersUseCase()
            _screenState.value = users
        }
    }
}