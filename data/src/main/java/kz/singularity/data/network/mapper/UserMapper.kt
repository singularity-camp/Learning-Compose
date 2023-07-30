package kz.singularity.data.network.mapper

import kz.singularity.data.db.room.entity.UserEntity
import kz.singularity.data.network.response.UserResponse
import kz.singularity.domain.models.User

class UserMapper(
    private val addressMapper: AddressMapper,
    private val companyMapper: CompanyMapper,
) {

    fun fromRemoteToDomain(userResponse: UserResponse): kz.singularity.domain.models.User {
        return kz.singularity.domain.models.User(
            email = userResponse.email,
            id = userResponse.id,
            name = userResponse.name,
            phone = userResponse.phone,
            username = userResponse.username,
            website = userResponse.website,
            /*address = addressMapper.fromRemoteToDomain(userResponse.address),
            company = companyMapper.fromRemoteToDomain(userResponse.company)*/
        )
    }

   /* fun fromEntityToDomain(userEntity: UserEntity): kz.singularity.domain.models.User {
        return kz.singularity.domain.models.User(
            email = userEntity.email,
            id = userEntity.id,
            name = userEntity.name,
            phone = userEntity.phone,
            username = userEntity.username,
            website = userEntity.website,
            address = addressMapper.(userEntity.address),
            company = companyMapper.fromRemoteToDomain(userEntity.company)
        )
    }

    fun fromDomainToEntity(user: User): UserEntity {
        return UserEntity(
            email = user.email,
            id = user.id,
            name = user.name,
            phone = user.phone,
            username = user.username,
            website = user.website
        )
    }*/


}