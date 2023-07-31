package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.ui.theme.CustomTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostCard(
    title: String,
    body: String,
    onClick: () -> Unit,
) {
    Card(
        backgroundColor = CustomTheme.colors.ui01,
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = CustomTheme.typography.h2,
                color = CustomTheme.colors.text01
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = body,
                style = CustomTheme.typography.body1,
                color = CustomTheme.colors.text02,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}