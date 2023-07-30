package kz.singularity.data.network.api

import kz.singularity.data.network.response.CommentResponse
import kz.singularity.data.network.response.PostResponse
import kz.singularity.data.network.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceholderService {

    @GET("users")
    suspend fun getUsers(): List<UserResponse>

    @GET("users/{id}")
    suspend fun getUserDetails(@Path("id") userId: Long): UserResponse

    @GET("posts")
    suspend fun getPosts(): List<PostResponse>

    @GET("posts/{id}")
    suspend fun getPostDetails(@Path("id") postId: Long): PostResponse

    @GET("comments")
    suspend fun getComments(): List<CommentResponse>

    @GET("posts/{id}/comments")
    suspend fun getCommentsFromPost(@Path("id") postId: Long): List<CommentResponse>
}