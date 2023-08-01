package kz.singularity.domain.repository

import kz.singularity.domain.models.Todo
import kz.singularity.domain.models.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUserById(userId: Long): User
    suspend fun getTodos(id: Long): List<Todo>
}