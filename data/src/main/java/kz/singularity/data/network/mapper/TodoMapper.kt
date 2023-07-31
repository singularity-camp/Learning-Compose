package kz.singularity.data.network.mapper

import kz.singularity.data.network.response.TodoResponse
import kz.singularity.domain.models.Todo

internal class TodoMapper {

    fun fromRemoteToDomain(todoResponse: TodoResponse): Todo {
        return Todo(
            completed = todoResponse.completed,
            id = todoResponse.id,
            title = todoResponse.title,
            userId = todoResponse.userId
        )
    }
}