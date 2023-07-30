package kz.singularity.learningcompose.ui.main

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.navigation.Destinations
import kz.singularity.learningcompose.ui.postDetails.CommentsFromPostPage

import kz.singularity.learningcompose.ui.posts.PostDetailsPage
import kz.singularity.learningcompose.ui.posts.PostsPage
import kz.singularity.learningcompose.ui.posts.UserPageTest
import kz.singularity.learningcompose.ui.theme.CustomTheme
import org.koin.androidx.compose.get

class MainActivity : AppCompatActivity() {

    val bottomNavItems = arrayOf(
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
                        //composable("postDetailed"){ postDetailed(post = )}
                    }

                    val currentBackStackEntry by navController.currentBackStackEntryAsState()
                    BottomNavigation(modifier = Modifier) {
                        bottomNavItems.forEach {
                            val isSelected = currentBackStackEntry?.destination?.route == it.route
                            val tint = if (isSelected) {
                                MaterialTheme.colors.secondary
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
                                })
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
    composable(BottomNavItems.Albums.route) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black))
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
        route = Destinations.CommentsFromPostPage.route,
        arguments = listOf(
            navArgument(Destinations.CommentsFromPostPage.postIdArg) { type = NavType.LongType }
        )
    ) { backStackEntry ->
        val postId = backStackEntry.arguments?.getLong(Destinations.CommentsFromPostPage.postIdArg)
        if (postId != null) {
            val viewModel = get<MainViewModel>()

            // Fetch comments for the specified postId
            viewModel.getCommentFromPost(postId)

            // Get the comments from the view model's state
            val comments = viewModel.commentFromPost

            // Call the CommentsFromPostPage composable and pass the comments list
            CommentsFromPostPage(comments = comments)
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


