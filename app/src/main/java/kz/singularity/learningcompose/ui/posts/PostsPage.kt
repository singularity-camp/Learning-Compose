package kz.singularity.learningcompose.ui.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kz.singularity.learningcompose.navigation.Destinations
import kz.singularity.learningcompose.ui.animation.LoadingShimmerEffect
import kz.singularity.learningcompose.ui.animation.ShimmerType
import org.koin.androidx.compose.get

@Composable
fun PostsPage(navController: NavController, viewModel: PostsPageViewModel = get()) {
    val posts = viewModel.posts
    val usernamesMapState = viewModel.usersNamesMap
    val isLoading = viewModel.isLoading

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(posts.size) { index ->
            val post = posts[index]
            val username = usernamesMapState[post.userId]

            if (isLoading.value) {
                LoadingShimmerEffect(shimmerType = ShimmerType.POSTS)
            } else {
                Post(
                    post = post,
                    onClick = {
                        navController.navigate(
                            Destinations.PostDetails.createRoute(
                                post.id,
                                username
                            )
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun Post(post: kz.singularity.domain.models.Post, onClick: () -> Unit) {
    kz.singularity.learningcompose.ui.views.Post(
        title = post.title,
        body = post.body,
        onClick = onClick
    )
}

