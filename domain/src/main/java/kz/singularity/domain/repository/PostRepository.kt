package kz.singularity.domain.repository

import kz.singularity.domain.models.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPostDetails(postId: Long): Post
}