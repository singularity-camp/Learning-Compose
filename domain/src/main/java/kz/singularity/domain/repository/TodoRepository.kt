package kz.singularity.domain.repository

import kz.singularity.domain.models.Todo

interface TodoRepository {
    suspend fun getTodosFromUser(userId: Long): List<Todo>
}