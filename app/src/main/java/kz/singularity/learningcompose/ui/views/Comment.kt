package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.theme.CustomTheme

@Composable
fun PostComment(
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
            Email(
                email = userEmail,
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

@Composable
fun Email(
    email: String,
    onClick: () -> Unit
) {
    Row {
        Text(
            text = stringResource(id = R.string.email) + ":",
            style = CustomTheme.typography.h4,
            color = CustomTheme.colors.text02
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            modifier = Modifier.clickable { onClick() },
            text = email,
            style = CustomTheme.typography.h4,
            color = CustomTheme.colors.link
        )
    }
}