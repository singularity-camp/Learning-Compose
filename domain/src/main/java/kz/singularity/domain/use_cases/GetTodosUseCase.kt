package kz.singularity.domain.use_cases

import kz.singularity.domain.repository.UserRepository

class GetTodosUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(id: Long) = repository.getTodos(id)
}