package kz.singularity.learningcompose.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kz.singularity.learningcompose.R

sealed class BottomNavItems(
    val screen: Screen,
    @StringRes val titleResId: Int,
    @DrawableRes val iconResId: Int,
) {

    object Posts : BottomNavItems(
        screen = Screen.Post,
        titleResId = R.string.posts,
        iconResId = R.drawable.ic_posts,
    )

    object Albums : BottomNavItems(
        screen = Screen.Album,
        titleResId = R.string.albums,
        iconResId = R.drawable.ic_albums,
    )

    object Users : BottomNavItems(
        screen = Screen.User,
        titleResId = R.string.users,
        iconResId = R.drawable.ic_users,
    )

    object Profile : BottomNavItems(
        screen = Screen.Profile,
        titleResId = R.string.Profile,
        iconResId = R.drawable.ic_profile,
    )
}