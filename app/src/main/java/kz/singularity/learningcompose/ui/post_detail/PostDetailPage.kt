package kz.singularity.learningcompose.ui.post_detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.extensions.sendMail
import kz.singularity.learningcompose.models.PostUI
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.views.PostCommentCard
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostDetailPage(
    post: PostUI,
    paddingValues: PaddingValues,
    onClick: () -> Unit
) {
    val viewModel: PostDetailViewModel = getViewModel { parametersOf(post) }

    val postDetailState = viewModel.screenState.value

    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.padding(paddingValues),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Post(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                title = postDetailState.title,
                name = postDetailState.userName ?: "",
                body = postDetailState.body
            )
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
        }

        stickyHeader {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = CustomTheme.colors.ui01)
                    .padding(vertical = 4.dp, horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.Comments),
                    style = CustomTheme.typography.h2,
                    color = CustomTheme.colors.text01
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.clickable { onClick() },
                    text = stringResource(id = R.string.show_all),
                    style = CustomTheme.typography.body1,
                    color = CustomTheme.colors.link
                )
            }
        }

        items(postDetailState.comments.size) {
            val comment = postDetailState.comments[it]
            PostCommentCard(
                modifier = Modifier.padding(horizontal = 16.dp),
                commentTitle = comment.name,
                userEmail = comment.email,
                commentBody = comment.body,
                onClick = {context.sendMail(comment.email)}
            )
        }
    }


}


@Composable
private fun Post(
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


