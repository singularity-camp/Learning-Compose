package kz.singularity.learningcompose.ui.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kz.singularity.domain.models.Comment
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.navigation.Destinations
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.views.CommentCard
import org.koin.androidx.compose.get


@Composable
fun PostDetailsPage(
    viewModel: PostDetailedViewModel = get(),
    postId: Long,
    username: String,
    navController: NavController
) {
    val comments = viewModel.commentsMap[postId]
    val post = viewModel.postsMap[postId]

    if (post != null) {
        val body = post.body
        val title = post.title

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item() {
                Title(title = title)
                Spacer(modifier = Modifier.size(16.dp))

                Username(username = username)
                Spacer(modifier = Modifier.size(32.dp)) //Too big spacer for me, but in figma there are 32 dp

                Body(body = body)
                Spacer(modifier = Modifier.size(24.dp))

                ShowAll(navController = navController, postId = postId)
            }

            if (comments != null) {
                items(comments.size) {
                    val comment = comments[it]
                    Comments(comment)
                }
            }
        }
    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.h1,
        color = CustomTheme.colors.text01
    )
}

@Composable
fun Username(username: String) {
    Row() {
        Text(
            text = stringResource(id = R.string.by),
            style = MaterialTheme.typography.body1,
            color = CustomTheme.colors.text01
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = username,
            style = MaterialTheme.typography.body1,
            color = CustomTheme.colors.main01
        )
    }
}

@Composable
fun Body(body: String) {
    Text(
        text = body,
        style = MaterialTheme.typography.body1,
        color = CustomTheme.colors.text01
    )
}

@Composable
fun ShowAll(navController: NavController, postId: Long) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.comments),
            style = MaterialTheme.typography.h2,
            color = CustomTheme.colors.text01
        )
        ClickableText(
            text = AnnotatedString("Show all"),
            onClick = {
                navController.navigate(
                    Destinations.CommentsFromPostPage.createRoute(
                        postId
                    )
                )
            },
            style = TextStyle(color = CustomTheme.colors.links)
        )
    }
}

@Composable
fun Comments(comment: Comment) {
    CommentCard(commentTitle = comment.name, userEmail = comment.email, commentBody = comment.body)
}

