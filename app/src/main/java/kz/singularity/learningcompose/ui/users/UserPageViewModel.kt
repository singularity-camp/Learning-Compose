package kz.singularity.learningcompose.ui.users

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.models.Todo
import kz.singularity.domain.models.User
import kz.singularity.domain.use_cases.GetTodosUseCase
import kz.singularity.domain.use_cases.GetUsersUseCase

class UserPageViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val getTodosUseCase: GetTodosUseCase
) : ViewModel() {
    private val _users = mutableStateListOf<User>()
    val user: SnapshotStateList<User> = _users

    init {
        viewModelScope.launch {
            _users.addAll(getUsersUseCase())
        }
    }

    fun getUserById(userId: Long): User? {
        return user.find { it.id.toLong() == userId }
    }

    private val _todosFromUser = mutableStateListOf<Todo>()
    val todosFromUser: SnapshotStateList<Todo> = _todosFromUser

    fun getTodosFromUser(userId: Long) {
        viewModelScope.launch {
            _todosFromUser.addAll(getTodosUseCase(userId))
        }
    }

}