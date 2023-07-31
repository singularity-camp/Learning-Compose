package kz.singularity.domain.use_cases

import kz.singularity.domain.repository.CommentRepository

class GetCommentsUseCase(
    private val repository: CommentRepository
) {
    suspend operator fun invoke() = repository.getComments()
}