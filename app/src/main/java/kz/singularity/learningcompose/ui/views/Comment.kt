package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostComment(
    commentTitle: String,
    userEmail: String,
    commentBody: String,
    onClick: () -> Unit,
) {
    Card(
        backgroundColor = MaterialTheme.colors.secondary,
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = commentTitle, style = MaterialTheme.typography.h2)
            Email(email = userEmail)
            Text(text = commentBody)
        }
    }
}

@Composable
fun Email(email: String) {
    Row {
        Text(text = stringResource(id = R.string.email) + ":", style = MaterialTheme.typography.h4, color = MaterialTheme.colors.secondary)
        Spacer(modifier = Modifier.size(8.dp))
    }
}