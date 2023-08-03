package kz.singularity.domain.use_cases

import kz.singularity.domain.models.Post
import kz.singularity.domain.models.User
import kz.singularity.domain.repository.PostRepository
import kz.singularity.domain.repository.UserRepository

class GetUsersUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(): List<User> {
        return repository.getUsers()
    }

    suspend operator fun invoke(userId: Long) : User {
        return repository.getUser(userId = userId)
    }
}