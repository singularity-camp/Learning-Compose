package kz.singularity.learningcompose.ui.main

import CurrentProfilePage
import UserProfilePage
import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.navigation.Destinations
import kz.singularity.learningcompose.ui.albums.AlbumsPage
import kz.singularity.learningcompose.ui.albums.PhotosPage
import kz.singularity.learningcompose.ui.posts.CommentsFromPostPage
import kz.singularity.learningcompose.ui.posts.PostDetailedViewModel
import kz.singularity.learningcompose.ui.posts.PostDetailsPage
import kz.singularity.learningcompose.ui.posts.PostsPage
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.user_profile.ToDoPage
import kz.singularity.learningcompose.ui.users.UserPage
import org.koin.androidx.compose.get

class MainActivity : AppCompatActivity() {

    private val bottomNavItems = arrayOf(
        BottomNavItems.Posts,
        BottomNavItems.Albums,
        BottomNavItems.Users,
        BottomNavItems.Profile
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            CustomTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    NavHost(
                        modifier = Modifier.weight(1f),
                        navController = navController,
                        startDestination = BottomNavItems.Posts.route
                    ) {
                        appendAllScreens(navController)
                    }

                    val currentBackStackEntry by navController.currentBackStackEntryAsState()
                    BottomNavigation(modifier = Modifier) {
                        bottomNavItems.forEach {
                            val isSelected = currentBackStackEntry?.destination?.route == it.route
                            val tint = if (isSelected) {
                                CustomTheme.colors.main01
                            } else {
                                Color.Unspecified
                            }
                            BottomNavigationItem(
                                selected = isSelected,
                                onClick = { navController.navigate(it.route) },
                                icon = {
                                    Icon(
                                        imageVector = ImageVector.vectorResource(id = it.iconRes),
                                        contentDescription = null,
                                        tint = tint,
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

fun NavGraphBuilder.appendAllScreens(navController: NavController) {
    composable(Destinations.Posts) {
        PostsPage(navController)
    }

    composable(Destinations.Users) {
        UserPage(navController)
    }

    composable(Destinations.Albums) {
        AlbumsPage(navController)
    }

    composable(Destinations.Profile) {
        CurrentProfilePage(userId = 2, navController)
    }

    composable(
        route = Destinations.PhotosFromAlbum.route,
        arguments = listOf(
            navArgument(Destinations.PhotosFromAlbum.almubIdArg) { type = NavType.LongType },
            navArgument(Destinations.PhotosFromAlbum.albumNameArg) { type = NavType.StringType },
            navArgument(Destinations.PhotosFromAlbum.usernameArg) { type = NavType.StringType }
        )
    ) {
        val albumId = it.arguments?.getLong(Destinations.PhotosFromAlbum.almubIdArg)
        val albumName = it.arguments?.getString(Destinations.PhotosFromAlbum.albumNameArg)
        val username = it.arguments?.getString(Destinations.PhotosFromAlbum.usernameArg)
        if (albumId != null && albumName != null && username != null) {
            PhotosPage(albumId = albumId, albumName = albumName, usernameOfAlbum = username)
        }
    }
    composable(
        route = Destinations.UserTodos.route,
        arguments = listOf(
            navArgument(Destinations.UserTodos.userIdArg) { type = NavType.LongType }
        )
    )
    { backStackEntry ->
        val userId = backStackEntry.arguments?.getLong(Destinations.UserTodos.userIdArg)
        if (userId != null) {
            ToDoPage(userId = userId)
        }
    }
    composable(
        route = Destinations.PostDetails.route,
        arguments = listOf(
            navArgument(Destinations.PostDetails.postIdArg) { type = NavType.LongType },
            navArgument(Destinations.PostDetails.usernameArg) { type = NavType.StringType }
        )
    ) { backStackEntry ->
        val postId = backStackEntry.arguments?.getLong(Destinations.PostDetails.postIdArg)
        val username = backStackEntry.arguments?.getString(Destinations.PostDetails.usernameArg)
        if (postId != null && username != null) {
            PostDetailsPage(postId = postId, username = username, navController = navController)
        }
    }

    composable(
        route = Destinations.UserProfile.route,
        arguments = listOf(
            navArgument(Destinations.UserProfile.userIdArg) { type = NavType.LongType }
        )
    ) { backStackEntry ->
        val userId = backStackEntry.arguments?.getLong(Destinations.UserProfile.userIdArg)
        if (userId != null) {
            UserProfilePage(userId)
        }
    }

    composable(
        route = Destinations.CommentsFromPostPage.route,
        arguments = listOf(
            navArgument(Destinations.CommentsFromPostPage.postIdArg) { type = NavType.LongType }
        )
    ) { backStackEntry ->
        val postId = backStackEntry.arguments?.getLong(Destinations.CommentsFromPostPage.postIdArg)
        if (postId != null) {
            val viewModel = get<PostDetailedViewModel>()
            val comments = viewModel.commentsMap[postId]

            if (comments != null) {
                CommentsFromPostPage(comments = comments)
            }
        }
    }
}


sealed class BottomNavItems(
    @DrawableRes val iconRes: Int,
    val route: String,
) {
    object Posts : BottomNavItems(iconRes = R.drawable.ic_posts, route = "Posts")
    object Albums : BottomNavItems(iconRes = R.drawable.ic_albums, route = "Albums")
    object Users : BottomNavItems(iconRes = R.drawable.ic_users, route = "Users")
    object Profile : BottomNavItems(iconRes = R.drawable.ic_profile, route = "Profile")
}


@Composable
fun MainScreen(
    text: String, onTextChange: (String) -> Unit
) {
    TextField(
        value = text, onValueChange = onTextChange, modifier = Modifier.fillMaxWidth()
    )
}

fun Activity.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}


