package kz.singularity.learningcompose.ui.users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kz.singularity.domain.models.Comment
import kz.singularity.domain.models.User
import kz.singularity.learningcompose.navigation.Destinations
import kz.singularity.learningcompose.ui.main.MainViewModel
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.views.PostComment
import org.koin.androidx.compose.get

@Composable
fun UserPageTest(
    navController: NavController,
    viewModel: UserPageViewModel = get()
) {
    val users = viewModel.user
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Users",
                style = MaterialTheme.typography.h1,
                color = CustomTheme.colors.text01
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
        items(users.size) {
            val user = users[it]
            Users(user, onClick = {
                val selectedUser = viewModel.getUserById(user.id.toLong())
                if (selectedUser != null) {
                    val route = Destinations.UserProfile.createRoute(selectedUser.id.toLong())
                    navController.navigate(route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            })
        }
    }

}

@Composable
fun Users(user: User, onClick: () -> Unit) {
    kz.singularity.learningcompose.ui.views.User(
        username = user.username,
        userEmail = user.email,
        name = user.name,
        onClick = onClick
    )
}