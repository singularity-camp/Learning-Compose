package kz.singularity.learningcompose.ui.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kz.singularity.learningcompose.navigation.Destinations
import kz.singularity.learningcompose.ui.main.MainViewModel
import org.koin.androidx.compose.get

@Composable
fun PostsPage(navController: NavController, viewModel: MainViewModel = get()) {
    val posts = viewModel.posts
    val usernamesMapState = rememberUpdatedState(viewModel.usersNamesMap)

    // Fetch usernames for each post's userId
    LaunchedEffect(posts) {
        posts.forEach { post ->
            viewModel.getUsersNames(post.userId)
        }
    }

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(posts.size) { index ->
            val post = posts[index]
            val username = usernamesMapState.value[post.userId]

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
            /* username?.let {
                 Text(it)
             }*/
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

/*
@Composable
fun navigateToPostDetails(navController: NavController, postId: Long, userId: Long) {
    navController.navigate("${BottomNavItems.PostDetails.route}/$postId/$userId")
}*/
