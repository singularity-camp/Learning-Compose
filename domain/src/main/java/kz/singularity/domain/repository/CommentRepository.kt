package kz.singularity.domain.repository

import kz.singularity.domain.models.Comment

interface CommentRepository {

    suspend fun getPostComments(postId: Long): List<Comment>

    suspend fun getComments(): List<Comment>
}