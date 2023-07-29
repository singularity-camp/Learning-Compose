package kz.singularity.domain.repository

import kz.singularity.domain.models.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUserById(userId: Long): User
}