package kz.singularity.data.network.mapper

import kz.singularity.data.network.response.AddressResponse
import kz.singularity.domain.models.Address

class AddressMapper(
    private val geoMapper: GeoMapper
) {

    fun fromRemoteToDomain(addressResponse: AddressResponse): Address {
        return Address(
            city = addressResponse.city,
            geo = geoMapper.fromRemoteToDomain(addressResponse.geo),
            street = addressResponse.street,
            suite = addressResponse.suite,
            zipcode = addressResponse.zipcode
        )
    }

    /*fun fromEnitityToDomain(addressEn)*/
}