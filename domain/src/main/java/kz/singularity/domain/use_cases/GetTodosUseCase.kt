package kz.singularity.domain.use_cases

import kz.singularity.domain.repository.TodoRepository
import kz.singularity.domain.models.Todo


class GetTodosUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke(userId: Long): List<Todo> {
        return repository.getTodosFromUser(userId)
    }

}