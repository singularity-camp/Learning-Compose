package kz.singularity.learningcompose.ui.users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kz.singularity.domain.models.User
import kz.singularity.learningcompose.navigation.Destinations
import kz.singularity.learningcompose.ui.posts.Title
import kz.singularity.learningcompose.ui.animation.LoadingShimmerEffect
import kz.singularity.learningcompose.ui.animation.ShimmerType
import org.koin.androidx.compose.get

@Composable
fun UserPage(
    navController: NavController,
    viewModel: UserPageViewModel = get()
) {
    val users = viewModel.user
    val isLoading = viewModel.isLoading

    if (isLoading.value) {
        LazyColumn() {
            items(8) {
                LoadingShimmerEffect(shimmerType = ShimmerType.USERS)
            }
        }
    } else {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                Title(title = "Users")
                Spacer(modifier = Modifier.size(16.dp))
            }

            items(users.size) {
                val user = users[it]
                Users(
                    user = user,
                    onClick = {
                        val route = Destinations.UserProfile.createRoute(user.id.toLong())
                        navController.navigate(route)
                    }
                )
            }
        }
    }
}

@Composable
fun Users(user: User, onClick: () -> Unit) {
    kz.singularity.learningcompose.ui.views.UserCard(
        username = user.username,
        userEmail = user.email,
        name = user.name,
        onClick = onClick
    )
}