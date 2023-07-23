package kz.singularity.learningcompose.ui.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.ui.main.MainViewModel
import org.koin.androidx.compose.get

@Composable
fun PostsPage(viewModel: MainViewModel = get()) {
    val posts = viewModel.posts
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(posts.size) {
            val post = posts[it]
            Post(
                post = post,
                onClick = {
                    viewModel.onPostClick(post.id)
                })
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