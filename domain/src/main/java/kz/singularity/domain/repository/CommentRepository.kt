package kz.singularity.domain.repository

import kz.singularity.domain.models.Comment

interface CommentRepository {
    suspend fun getComments(): List<Comment>
    suspend fun getCommentsFromPost(postId: Long): List<Comment>

}