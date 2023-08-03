package kz.singularity.data.repository


import kz.singularity.data.db.room.dao.UserDao
import kz.singularity.data.network.api.PlaceholderService
import kz.singularity.data.network.mapper.UserMapper
import kz.singularity.domain.models.Comment
import kz.singularity.domain.models.User
import kz.singularity.domain.repository.UserRepository

class UserRepositoryImpl(
    private val placeholderService: PlaceholderService,
    private val userMapper: UserMapper,
    private val userDao: UserDao
) : UserRepository {

    val userCache = mutableListOf<User>()

   /* override suspend fun getUsers(): List<User> {

        if (userCache.isNotEmpty()) {
            return userCache
        }

        val userEntities = userDao.getUser()

        if (userEntities.isNotEmpty()) {
            val users = userEntities.map { userEntity ->
                userMapper.fromEntityToDomain(userEntity)
            }
            userCache.addAll(users)
            return users
        }

        val remoteUsers = placeholderService.getUsers()
        val users =
            remoteUsers.map { userResponse -> userMapper.fromRemoteToDomain(userResponse) }
        userCache.addAll(users)

        val userEntitiesToStore = users.map { comment -> userMapper.fromDomainToEntity(comment) }
        userDao.addUser(userEntitiesToStore)
        return users

    }*/

    override suspend fun getUsers(): List<User> {
        val userResponse = placeholderService.getUsers()
        return userResponse.map { userMapper.fromRemoteToDomain(it) }
    }

    override suspend fun getUser(userId: Long): User {
        val userResponse = placeholderService.getUserDetails(userId)
        return userMapper.fromRemoteToDomain(userResponse)
    }

    /*  override suspend fun getUsernameFromPost(userId: Long): String {
          TODO("Not yet implemented")
      }*/


}