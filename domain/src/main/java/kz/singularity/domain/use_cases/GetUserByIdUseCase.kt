package kz.singularity.domain.use_cases

import kz.singularity.domain.repository.UserRepository

class GetUserByIdUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userId: Long) = repository.getUserById(userId)
}