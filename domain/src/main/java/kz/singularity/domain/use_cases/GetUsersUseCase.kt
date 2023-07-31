package kz.singularity.domain.use_cases

import kz.singularity.domain.repository.UserRepository

class GetUsersUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke() = repository.getUsers()
}