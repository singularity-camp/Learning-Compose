package kz.singularity.domain.repository

import kz.singularity.domain.models.Comment
import kz.singularity.domain.models.User

interface UserRepository  {
    suspend fun getUsers(): List<User>
    suspend fun getUser(userId: Long): User
}