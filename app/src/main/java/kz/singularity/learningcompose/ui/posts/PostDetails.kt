package kz.singularity.learningcompose.ui.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.singularity.domain.models.Comment
import kz.singularity.domain.models.Post
import kz.singularity.learningcompose.navigation.Destinations
import kz.singularity.learningcompose.ui.main.MainViewModel
import kz.singularity.learningcompose.ui.main.postDetailedViewModel
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.views.Email
import kz.singularity.learningcompose.ui.views.PostComment
import org.koin.androidx.compose.get


@Composable
fun PostDetailsPage(
    viewModel: postDetailedViewModel = get(),
    postId: Long,
    username: String,
    navController: NavController
) {
    viewModel.getCommentFromPost(postId)
    val comments = viewModel.commentFromPost

    val post = viewModel.getPostByPageId(postId)
    if (post != null) {
        val body = post.body
        val title = post.title

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item() {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h1,
                    color = CustomTheme.colors.text01
                )
                Spacer(modifier = Modifier.size(16.dp))
                Row() {
                    Text(
                        text = "By:",
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
                Text(
                    text = body,
                    style = MaterialTheme.typography.body1,
                    color = CustomTheme.colors.text01
                )
                Spacer(modifier = Modifier.size(24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Comments",
                        style = MaterialTheme.typography.h2,
                        color = CustomTheme.colors.text01
                    )
                    //val navController = rememberNavController()
                    ClickableText(
                        text = AnnotatedString("Show all"),
                        onClick = {
                            // Navigate to CommentsFromPostPage
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

            items(comments.size) {
                val comment = comments[it]
                Comments(comment)
            }
        }
    }
}


@Composable
fun Comments(comment: Comment) {
    PostComment(commentTitle = comment.name, userEmail = comment.email, commentBody = comment.body)
}

