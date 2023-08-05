package kz.singularity.domain.use_cases

import kz.singularity.domain.models.Post
import kz.singularity.domain.models.PostDetails
import kz.singularity.domain.repository.PostRepository

class GetPostsUseCase(private val repository: PostRepository) {
    suspend operator fun invoke(): List<Post> {
        return repository.getPosts()
    }

    /*suspend fun getUserIdFromPost(postId: Long): PostDetails {
        return repository.getUserIdFromPost(postId)
    }*/
}