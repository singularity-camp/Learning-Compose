package kz.singularity.domain.use_cases

import kz.singularity.domain.models.Comment
import kz.singularity.domain.repository.CommentRepository


class GetCommentsUseCase(private val repository: CommentRepository) {
    suspend operator fun invoke(): List<Comment>  {
        return repository.getComments()
    }
    suspend operator fun invoke(postId: Long): List<Comment> {
        return repository.getCommentsFromPost(postId)
    }

}