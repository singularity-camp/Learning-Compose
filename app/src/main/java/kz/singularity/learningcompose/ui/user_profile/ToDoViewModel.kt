package kz.singularity.learningcompose.ui.user_profile

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

class ToDoViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val getTodosUseCase: GetTodosUseCase
) : ViewModel() {
    private val _users = mutableStateListOf<User>()
    private val _userIdToTodosMap: SnapshotStateMap<Long, SnapshotStateList<Todo>> = mutableStateMapOf()
    val userIdToTodosMap: SnapshotStateMap<Long, SnapshotStateList<Todo>> get() = _userIdToTodosMap

    init {
        viewModelScope.launch {
            val users = getUsersUseCase()
            _users.addAll(users)

            users.forEach { user ->
                _userIdToTodosMap[user.id.toLong()] = mutableStateListOf()
                val todos = getTodosUseCase(user.id.toLong())
                _userIdToTodosMap[user.id.toLong()]?.addAll(todos)
            }
        }
    }

    fun updateTodoCompletion(userId: Long, updatedTodo: Todo) {
        val todos = _userIdToTodosMap[userId]
        val todoIndex = todos?.indexOfFirst { it.id == updatedTodo.id }
        if (todoIndex != null && todoIndex >= 0) {
            todos[todoIndex] = updatedTodo
        }
    }
}