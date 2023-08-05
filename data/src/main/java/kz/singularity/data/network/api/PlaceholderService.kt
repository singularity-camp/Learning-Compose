package kz.singularity.data.network.api

import kz.singularity.data.network.response.AlbumResponse
import kz.singularity.data.network.response.CommentResponse
import kz.singularity.data.network.response.PhotoResponse
import kz.singularity.data.network.response.PostResponse
import kz.singularity.data.network.response.TodoResponse
import kz.singularity.data.network.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceholderService {

    @GET("users")
    suspend fun getUsers(): List<UserResponse>

    @GET("users/{id}")
    suspend fun getUserDetails(@Path("id") userId: Long): UserResponse

    @GET("users/{id}/todos")
    suspend fun getTodosFromUser(@Path("id") userId: Long): List<TodoResponse>

    @GET("posts")
    suspend fun getPosts(): List<PostResponse>

    @GET("posts/{id}")
    suspend fun getPostDetails(@Path("id") postId: Long): PostResponse

    @GET("comments")
    suspend fun getComments(): List<CommentResponse>

    @GET("posts/{id}/comments")
    suspend fun getCommentsFromPost(@Path("id") postId: Long): List<CommentResponse>

    @GET("albums")
    suspend fun getAlbums(): List<AlbumResponse>

    @GET("photos")
    suspend fun getPhotos(): List<PhotoResponse>

    @GET("photos/{id}")
    suspend fun getPhotoDetails(@Path("id") albumId: Long): PhotoResponse

    @GET("albums/{id}/photos")
    suspend fun getPhotosFromAlbum(@Path("id") albumId: Long): List<PhotoResponse>
}