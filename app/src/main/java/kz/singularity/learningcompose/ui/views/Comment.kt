package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.theme.CustomTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostComment(
    commentTitle: String,
    userEmail: String,
    commentBody: String,
) {
    Card(
        backgroundColor = CustomTheme.colors.ui01,
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = commentTitle,
                style = MaterialTheme.typography.h2,
                color = CustomTheme.colors.text01
            )
            Spacer(modifier = Modifier.size(8.dp))
            Email(email = userEmail)
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = commentBody,
                style = MaterialTheme.typography.body1,
                color = CustomTheme.colors.text01,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun Email(email: String) {
    Row {
        Text(
            text = stringResource(id = R.string.email) + ":",
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text02
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = email,
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.links)
    }
}