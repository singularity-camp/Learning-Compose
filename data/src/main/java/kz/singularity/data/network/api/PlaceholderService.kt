package kz.singularity.data.network.api

import kz.singularity.data.network.response.CommentResponse
import kz.singularity.data.network.response.PostResponse
import kz.singularity.data.network.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceholderService {
    @GET("posts")
    suspend fun getPosts(): List<PostResponse>

    @GET("posts/{id}")
    suspend fun getPostDetails(@Path("id") postId: Long): PostResponse

    @GET("users")
    suspend fun getUsers(): List<UserResponse>

    @GET("users/{id}")
    suspend fun getUserbyId(@Path("id") postId: Long): UserResponse


    @GET("comments")
    suspend fun getComments(): List<CommentResponse>

    @GET("posts/{id}/comments")
    suspend fun getPostComments(@Path("id") postId: Long): List<CommentResponse>


}