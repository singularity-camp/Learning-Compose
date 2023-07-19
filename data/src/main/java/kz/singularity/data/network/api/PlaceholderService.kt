package kz.singularity.data.network.api

import kz.singularity.data.network.response.PostResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceholderService {
    @GET("posts")
    suspend fun getPosts(): List<PostResponse>

    @GET("posts/{id}")
    suspend fun getPostDetails(@Path("id") postId: Long): PostResponse
}