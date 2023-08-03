package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.singularity.domain.models.Todo
import kz.singularity.learningcompose.ui.theme.CustomTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ToDoItem(todo: Todo) {
    Card(
        backgroundColor = CustomTheme.colors.ui01,
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
      //  backgroundColor = if (todo.completed) MaterialTheme.colors.secondary else MaterialTheme.colors.surface,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = todo.title,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.weight(1f)
                )
                Checkbox(
                    checked = todo.completed,
                    onCheckedChange = null,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}