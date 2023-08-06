package kz.singularity.learningcompose.ui.user_profile

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.ui.views.ToDoCard
import org.koin.androidx.compose.get

@Composable
fun ToDoPage(userId: Long, viewModel: ToDoViewModel = get()){
    val todos = viewModel.userIdToTodosMap[userId]

    if (todos != null) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ){
            items(todos.size) {
                val todo = todos[it]

                ToDoCard(todo) { updatedTodo ->
                    viewModel.updateTodoCompletion(userId, updatedTodo)
                }
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}