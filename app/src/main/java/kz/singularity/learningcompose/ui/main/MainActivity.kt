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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.navigation.BottomNavItems
import kz.singularity.learningcompose.navigation.Screen
import kz.singularity.learningcompose.ui.posts.PostsPage
import kz.singularity.learningcompose.ui.theme.CustomTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            CustomTheme {
                Scaffold(
                    bottomBar = { BottomNavigationBar(navHostController = navController)}
                ) {paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = BottomNavItems.Posts.screen.route
                    ) {
                        appendAllScreens(paddingValues = paddingValues)
                    }
                }
            }
        }
    }
}

fun NavGraphBuilder.appendAllScreens(paddingValues: PaddingValues) {

    navigation(
        startDestination = Screen.Posts.route,
        route = Screen.Post.route
    ) {
        composable(Screen.Posts.route){
            PostsPage(paddingValues = paddingValues)
        }

        composable(Screen.PostDetail.route){

        }

        composable(Screen.PostsComments.route) {

        }

    }

    navigation(
        startDestination = Screen.Albums.route,
        route = Screen.Album.route
    ) {
        composable(Screen.Albums.route){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            )
        }

        composable(Screen.AlbumPhotos.route){

        }

    }

}


@Composable
private fun BottomNavigationBar(navHostController: NavHostController) {
    BottomNavigation(
        backgroundColor = CustomTheme.colors.container
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
                        tint = if (selected) CustomTheme.colors.main_01 else Color.Black
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


