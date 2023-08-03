package kz.singularity.data.repository


import kz.singularity.domain.repository.TodoRepository
import kz.singularity.data.network.api.PlaceholderService
import kz.singularity.data.network.mapper.TodoMapper
import kz.singularity.domain.models.Todo

class TodoRepositoryImpl(
    private val placeholderService: PlaceholderService,
    private val mapper: TodoMapper,
) : TodoRepository {

    override suspend fun getTodosFromUser(userId: Long): List<Todo> {
        val response = placeholderService.getTodosFromUser(userId)
        return response.map { mapper.fromRemoteToDomain(it) }
    }
}