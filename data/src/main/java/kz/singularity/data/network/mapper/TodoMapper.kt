package kz.singularity.data.network.mapper

import kz.singularity.data.network.response.PhotoResponse
import kz.singularity.data.network.response.TodoResponse

class TodoMapper {

    fun fromRemoteToDomain(response: TodoResponse): kz.singularity.domain.models.Todo {
        return kz.singularity.domain.models.Todo(
            id = response.id,
            title = response.title,
            userId = response.userId,
            completed = response.completed
        )
    }
}