package kz.singularity.data.repository

import kz.singularity.data.network.api.PlaceholderService
import kz.singularity.data.network.mapper.CommentMapper
import kz.singularity.domain.models.Comment
import kz.singularity.domain.repository.CommentRepository

internal class CommentRepositoryImpl(
    private val placeholderService: PlaceholderService,
    private val commentMapper: CommentMapper
) : CommentRepository {
    override suspend fun getPostComments(postId: Long): List<Comment> {
        val commentResponses = placeholderService.getPostComments(postId)
        return commentResponses.map { commentMapper.fromRemoteToDomain(it) }
    }

    override suspend fun getComments(): List<Comment> {
        val commentResponses = placeholderService.getComments()
        return commentResponses.map { commentMapper.fromRemoteToDomain(it) }
    }

}