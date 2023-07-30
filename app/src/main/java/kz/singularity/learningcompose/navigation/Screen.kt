package kz.singularity.learningcompose.navigation

import android.net.Uri
import com.google.gson.Gson
import kz.singularity.learningcompose.models.AlbumUI
import kz.singularity.learningcompose.models.PostUI


sealed class Screen(
    val route: String
) {

    //Post
    object Post : Screen(POST_GRAPH_ROUTE)
    object Posts : Screen(POSTS)
    object PostDetail : Screen(POST_DETAIL) {
        private const val ROUTE_FOR_ARGS = "post_detail"

        fun getRouteArgs(post: PostUI): String {
            val postJson = Gson().toJson(post)
            return "$ROUTE_FOR_ARGS/$postJson"
        }
    }

    object PostsComments : Screen(POSTS_COMMENTS)


    //Album
    object Album : Screen(ALBUM_GRAPH_ROUTE)
    object Albums : Screen(ALBUMS)
    object AlbumPhotos : Screen(ALBUM_PHOTOS){
        private const val ROUTE_FOR_ARGS = "album_photos"

        fun getRouteArgs(album:AlbumUI):String{
            val albumJson = Gson().toJson(album)
            return "$ROUTE_FOR_ARGS/$albumJson"
        }
    }


    //User
    object User : Screen(USER_GRAPH_ROUTE)
    object Users : Screen(USERS)
    object UserProfile : Screen(USER_PROFILE)


    //Profile
    object Profile : Screen(PROFILE_GRAPH_ROUTE)
    object CurrentProfile : Screen(CURRENT_PROFILE)
    object ToDos : Screen(TO_DOS)


    internal fun String.encode() = Uri.encode(this)


    companion object {
        const val POST = "post"
        const val ALBUM = "album"

        //Post
        private const val POST_GRAPH_ROUTE = "post_graph"
        private const val POSTS = "posts"
        private const val POST_DETAIL = "post_detail/{$POST}"
        private const val POSTS_COMMENTS = "posts_comments"

        //Album
        private const val ALBUM_GRAPH_ROUTE = "album_graph"
        private const val ALBUMS = "albums"
        private const val ALBUM_PHOTOS = "album_photos/{$ALBUM}"

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
