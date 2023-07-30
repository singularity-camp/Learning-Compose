package kz.singularity.learningcompose.ui.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import kz.singularity.domain.models.Comment
import kz.singularity.domain.models.User
import kz.singularity.learningcompose.ui.main.MainViewModel
import kz.singularity.learningcompose.ui.views.PostComment
import org.koin.androidx.compose.get

@Composable
fun UserPageTest(viewModel: MainViewModel = get(), postId:Long) {
    /*val users = viewModel.user
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(users.size) {
            val user = users[it]
            Users(user)
        }
    }*/
  /*  val userId = viewModel.getUserIdFromPost(postId)
    Text("$userId")*/
}

@Composable
fun Users(user: User) {
    kz.singularity.learningcompose.ui.views.User(
       username = user.username,
        userEmail = user.email,
        name = user.name
    )
}