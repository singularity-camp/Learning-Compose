package kz.singularity.data.repository

import kz.singularity.data.network.api.PlaceholderService
import kz.singularity.data.network.mapper.UserMapper
import kz.singularity.domain.models.User
import kz.singularity.domain.repository.UserRepository

internal class UserRepositoryImpl(
    private val placeholderService: PlaceholderService,
    private val userMapper: UserMapper
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        val userResponse = placeholderService.getUsers()
        return userResponse.map { userMapper.fromRemoteToDomain(it) }
    }

    override suspend fun getUserById(userId: Long): User {
        val userResponse = placeholderService.getUserById(userId)
        return userMapper.fromRemoteToDomain(userResponse)
    }
}