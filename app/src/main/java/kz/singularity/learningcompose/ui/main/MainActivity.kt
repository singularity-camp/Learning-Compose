package kz.singularity.learningcompose.ui.main

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import kz.singularity.learningcompose.models.PostUI
import kz.singularity.learningcompose.navigation.BottomNavItems
import kz.singularity.learningcompose.navigation.Screen
import kz.singularity.learningcompose.ui.comments.CommentsPage
import kz.singularity.learningcompose.ui.post_detail.PostDetailPage
import kz.singularity.learningcompose.ui.posts.PostsPage
import kz.singularity.learningcompose.ui.theme.CustomTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            CustomTheme {
                Scaffold(
                    bottomBar = { BottomNavigationBar(navHostController = navController) }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = BottomNavItems.Posts.screen.route
                    ) {
                        appendAllScreens(
                            paddingValues = paddingValues,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

fun NavGraphBuilder.appendAllScreens(
    paddingValues: PaddingValues,
    navController: NavHostController
) {

    navigation(
        startDestination = Screen.Posts.route,
        route = Screen.Post.route
    ) {
        composable(Screen.Posts.route) {
            PostsPage(
                paddingValues = paddingValues,
                onPostClick = { post ->
                    navController.navigate(Screen.PostDetail.getRouteArgs(post))
                }
            )
        }

        composable(
            route = Screen.PostDetail.route,
            arguments = listOf(navArgument(Screen.POST) { type = PostUI.NavigationType })
        ) {
            val post = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.arguments?.getParcelable(Screen.POST, PostUI::class.java)
            } else {
                it.arguments?.getParcelable(Screen.POST)
            } ?: throw RuntimeException("Args is null")

            PostDetailPage(
                post = post,
                paddingValues = paddingValues,
                onClick = { navController.navigate(Screen.PostsComments.route) }
            )
        }

        composable(Screen.PostsComments.route) {
            CommentsPage(paddingValues = paddingValues)
        }

    }

    navigation(
        startDestination = Screen.Albums.route,
        route = Screen.Album.route
    ) {
        composable(Screen.Albums.route) {

        }

        composable(Screen.AlbumPhotos.route) {

        }

    }

}


@Composable
private fun BottomNavigationBar(navHostController: NavHostController) {
    BottomNavigation(
        backgroundColor = CustomTheme.colors.ui01
    ) {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()

        val items = listOf(
            BottomNavItems.Posts,
            BottomNavItems.Albums,
            BottomNavItems.Users,
            BottomNavItems.Profile
        )
        items.forEach { item ->

            val selected = navBackStackEntry?.destination?.hierarchy?.any {
                it.route == item.screen.route
            } ?: false

            BottomNavigationItem(
                selected = selected,
                onClick = {
                    if (!selected) navHostController.navigateTo(item.screen.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconResId),
                        contentDescription = null,
                        tint = if (selected) CustomTheme.colors.main01 else CustomTheme.colors.ui02
                    )
                },
                selectedContentColor = MaterialTheme.colors.onPrimary,
                unselectedContentColor = MaterialTheme.colors.onSecondary
            )
        }
    }
}

private fun NavHostController.navigateTo(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
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


