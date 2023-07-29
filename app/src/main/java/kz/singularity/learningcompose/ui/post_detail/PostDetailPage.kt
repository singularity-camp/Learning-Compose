package kz.singularity.learningcompose.ui.post_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.models.PostUI
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.views.PostComment
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun PostDetailPage(
    post: PostUI,
    paddingValues: PaddingValues,
    onClick: () -> Unit
) {
    val viewModel: PostDetailViewModel = getViewModel { parametersOf(post) }

    val postDetailState = viewModel.screenState.value

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PostItem(
                modifier = Modifier.fillMaxWidth(),
                title = postDetailState.title,
                name = postDetailState.userName ?: "",
                body = postDetailState.body
            )
        }
        items(postDetailState.comments.size) {
            val comment = postDetailState.comments[it]
            PostComment(
                commentTitle = comment.name,
                userEmail = comment.email,
                commentBody = comment.body,
                onClick = {}
            )
        }
    }


}


@Composable
private fun PostItem(
    modifier: Modifier = Modifier,
    title: String,
    name: String,
    body: String,
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = CustomTheme.typography.h1,
            color = CustomTheme.colors.text01
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = CustomTheme.colors.text01)) {
                    append(stringResource(id = R.string.by))
                    append(": ")
                }
                withStyle(style = SpanStyle(color = CustomTheme.colors.main01)) {
                    append(name)
                }
            },
            style = CustomTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = body,
            style = CustomTheme.typography.body1,
            color = CustomTheme.colors.text01
        )
    }
}


