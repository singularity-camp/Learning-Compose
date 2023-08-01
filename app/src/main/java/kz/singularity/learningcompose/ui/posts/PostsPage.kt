package kz.singularity.learningcompose.ui.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.models.PostUI
import kz.singularity.learningcompose.ui.main.MainViewModel
import kz.singularity.learningcompose.ui.views.PostCard
import org.koin.androidx.compose.getViewModel

@Composable
fun PostsPage(
    paddingValues: PaddingValues,
    onPostClick: (PostUI) -> Unit
) {
    val viewModel: MainViewModel = getViewModel()

    val posts = viewModel.posts
    LazyColumn(
        modifier = Modifier.padding(paddingValues),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(posts.size) {
            val post = posts[it]
            PostCard(
                title = post.title,
                body = post.body,
                onClick = { onPostClick(post) }
            )
        }
    }
}