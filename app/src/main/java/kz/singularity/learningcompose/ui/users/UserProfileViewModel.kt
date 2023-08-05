package kz.singularity.learningcompose.ui.users

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.models.Todo
import kz.singularity.domain.models.User
import kz.singularity.domain.use_cases.GetTodosUseCase
import kz.singularity.domain.use_cases.GetUsersUseCase

class UserProfileViewModel(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {
    private val _users = mutableStateListOf<User>()

    private val _userIdToUserMap = mutableStateMapOf<Long, User>()
    val userIdToUserMap: SnapshotStateMap<Long, User> = _userIdToUserMap

    init {
        viewModelScope.launch {
            val users = getUsersUseCase()
            _users.addAll(users)

            users.forEach{
                _userIdToUserMap[it.id.toLong()] = it
            }
        }
    }

   /* private val _todosFromUser = mutableStateListOf<Todo>()
    val todosFromUser: SnapshotStateList<Todo> = _todosFromUser

    fun getTodosFromUser(userId: Long) {
        viewModelScope.launch {
            _todosFromUser.addAll(getTodosUseCase(userId))
        }
    }*/

}