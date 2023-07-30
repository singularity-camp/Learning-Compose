package kz.singularity.domain.repository

import kz.singularity.domain.models.Post
import kz.singularity.domain.models.PostDetails

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPostDetails(postId: Long): Post
   // suspend fun getUserIdFromPost(postId: Long) : PostDetails

}