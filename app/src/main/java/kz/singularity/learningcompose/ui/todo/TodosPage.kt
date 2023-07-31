package kz.singularity.learningcompose.ui.todo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.views.TaskCard
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun TodosPage(
    userId: Long,
    paddingValues: PaddingValues
) {

    val viewModel: TodosViewModel = getViewModel { parametersOf(userId) }

    val todos = viewModel.todos.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.your_todos),
            style = CustomTheme.typography.h1,
            color = CustomTheme.colors.text01,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(todos.size) {
                val todo = todos[it]
                TaskCard(
                    modifier = Modifier.fillMaxSize(),
                    taskName = todo.title,
                    checked = todo.completed,
                    onCheckedChange = { viewModel.changeStatus(todo.id) }
                )
            }
        }

    }

}