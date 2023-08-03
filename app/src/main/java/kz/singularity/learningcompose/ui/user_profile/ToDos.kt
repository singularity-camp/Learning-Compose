package kz.singularity.learningcompose.ui.user_profile

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.ui.users.UserPageViewModel
import kz.singularity.learningcompose.ui.views.ToDoItem
import org.koin.androidx.compose.get

@Composable
fun YourTodos(userId: Long, viewModel: UserPageViewModel = get()){
    val user = viewModel.getUserById(userId = userId)
    viewModel.getTodosFromUser(userId)
    val todos = viewModel.todosFromUser

    if (user != null) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ){
            items(todos.size) {
                val todo = todos[it]
                ToDoItem(todo)
                Divider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}