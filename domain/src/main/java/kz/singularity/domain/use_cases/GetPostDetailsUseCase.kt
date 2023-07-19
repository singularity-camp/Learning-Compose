package kz.singularity.domain.use_cases

import kz.singularity.domain.models.Post
import kz.singularity.domain.repository.PostRepository

class GetPostDetailsUseCase(private val postRepository: PostRepository) {
    suspend operator fun invoke(postId: Long): Post {
        return postRepository.getPostDetails(postId = postId)
    }
}