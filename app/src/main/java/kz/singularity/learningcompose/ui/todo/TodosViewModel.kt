package kz.singularity.learningcompose.ui.todo

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.models.Todo
import kz.singularity.domain.use_cases.GetTodosUseCase

class TodosViewModel(
    private val userId: Long,
    private val getTodosUseCase: GetTodosUseCase
) : ViewModel() {

    private val _todos = mutableStateOf<List<Todo>>(emptyList())
    val todos: State<List<Todo>> = _todos

    init {
        getTodos()
    }

    fun changeStatus(id: Long) {
        val modifiedTodos = _todos.value.toMutableList().apply {
            replaceAll { todo ->
                if (todo.id == id) {
                    todo.copy(completed = !todo.completed)
                } else {
                    todo
                }
            }
        }
        _todos.value = modifiedTodos
    }

    private fun getTodos() {
        viewModelScope.launch {
            val result = getTodosUseCase(userId)
            Log.d("TEST TODOS", "result: $result")
            _todos.value = result
        }
    }
}