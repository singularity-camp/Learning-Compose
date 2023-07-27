package kz.singularity.learningcompose.navigation

import android.net.Uri


sealed class Screen(
    val route: String
) {

    //Post
    object Post : Screen(POST_GRAPH_ROUTE)
    object Posts : Screen(POSTS)
    object PostDetail : Screen(POST_DETAIL)
    object PostsComments : Screen(POSTS_COMMENTS)


    //Album
    object Album : Screen(ALBUM_GRAPH_ROUTE)
    object Albums:Screen(ALBUMS)
    object AlbumPhotos:Screen(ALBUM_PHOTOS)


    //User
    object User : Screen(USER_GRAPH_ROUTE)
    object Users:Screen(USERS)
    object UserProfile:Screen(USER_PROFILE)


    //Profile
    object Profile : Screen(PROFILE_GRAPH_ROUTE)
    object CurrentProfile:Screen(CURRENT_PROFILE)
    object ToDos:Screen(TO_DOS)



    internal fun String.encode() = Uri.encode(this)


    companion object {

        //Post
        private const val POST_GRAPH_ROUTE = "post_graph"
        private const val POSTS = "posts"
        private const val POST_DETAIL = "post_detail"
        private const val POSTS_COMMENTS = "posts_comments"

        //Album
        private const val ALBUM_GRAPH_ROUTE = "album_graph"
        private const val ALBUMS = "albums"
        private const val ALBUM_PHOTOS = "album_photos"

        //User
        private const val USER_GRAPH_ROUTE = "user_graph"
        private const val USERS = "users"
        private const val USER_PROFILE = "user_profile"

        //Profile
        private const val PROFILE_GRAPH_ROUTE = "profile_graph"
        private const val CURRENT_PROFILE = "current_profile"
        private const val TO_DOS = "to_dos"
    }
}
