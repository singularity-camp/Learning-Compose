package kz.singularity.data.network.mapper

import kz.singularity.data.network.response.UserResponse
import kz.singularity.domain.models.User

internal class UserMapper(
    private val addressMapper: AddressMapper,
    private val companyMapper: CompanyMapper,
) {

    fun fromRemoteToDomain(userResponse: UserResponse): User {
        return User(
            address = addressMapper.fromRemoteToDomain(userResponse.address),
            company = companyMapper.fromRemoteToDomain(userResponse.company),
            email = userResponse.email,
            id = userResponse.id,
            name = userResponse.name,
            phone = userResponse.phone,
            username = userResponse.username,
            website = userResponse.website
        )
    }
}