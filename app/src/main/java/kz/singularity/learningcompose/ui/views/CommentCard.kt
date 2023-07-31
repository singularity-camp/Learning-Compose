package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.theme.CustomTheme

@Composable
fun PostCommentCard(
    modifier: Modifier = Modifier,
    commentTitle: String,
    userEmail: String,
    commentBody: String,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier,
        backgroundColor = CustomTheme.colors.ui01,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = commentTitle,
                style = CustomTheme.typography.h2,
                color = CustomTheme.colors.text01
            )
            Spacer(modifier = Modifier.height(8.dp))
            InfoSnippet(
                label = R.string.email,
                value = userEmail,
                onClick = onClick
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = commentBody,
                style = CustomTheme.typography.body1,
                color = CustomTheme.colors.text01
            )
        }
    }
}

