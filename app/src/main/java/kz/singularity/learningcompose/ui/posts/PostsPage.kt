package kz.singularity.learningcompose.ui.posts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Post(post: kz.singularity.domain.models.Post, onClick: () -> Unit) {
    Card(
        backgroundColor = MaterialTheme.colors.secondary,
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = post.title,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = post.body,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSecondary
            )
        }
    }
}