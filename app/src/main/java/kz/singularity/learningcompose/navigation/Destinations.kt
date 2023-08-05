package kz.singularity.learningcompose.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

object Destinations {
    const val Posts = "Posts"
    const val Albums = "Albums"
    const val Users = "Users"
    const val Profile = "Profile"

    object PostDetails {
        const val route = "PostDetails/{postId}/{username}"
        const val postIdArg = "postId"
        const val usernameArg = "username"

        fun createRoute(postId: Long, username: String?): String {
            return "PostDetails/$postId/$username"
        }
    }

    object CommentsFromPostPage {
        const val route = "CommentsFromPostPage/{postId}"
        const val postIdArg = "postId"

        fun createRoute(postId: Long): String {
            return "CommentsFromPostPage/$postId"
        }
    }

    object UserProfile {
        const val route = "UserProfile/{userId}"
        const val userIdArg = "userId"

        fun createRoute(userId: Long): String {
            return "UserProfile/$userId"
        }
    }

    object UserTodos {
        const val route = "UserTodos/{userId}"
        const val userIdArg = "userId"

        fun createRoute(userId: Long): String {
            return "UserTodos/$userId"
        }
    }

    object PhotosFromAlbum{
        const val route = "PhotosFromAlbum/{albumId}/{albumName}/{username}"
        const val almubIdArg = "albumId"
        const val albumNameArg = "albumName"
        const val usernameArg = "username"

        fun createRoute(albumId:Long, albumName: String, username: String) : String{
            return "PhotosFromAlbum/$albumId/$albumName/$username"
        }
    }


}