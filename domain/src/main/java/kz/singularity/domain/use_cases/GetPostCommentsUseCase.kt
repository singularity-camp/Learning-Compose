package kz.singularity.domain.use_cases

import kz.singularity.domain.repository.CommentRepository

class GetPostCommentsUseCase(
    private val repository: CommentRepository
) {
    suspend operator fun invoke(postId: Long) = repository.getPostComments(postId)
}