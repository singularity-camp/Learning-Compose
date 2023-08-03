package kz.singularity.data.network.mapper

import kz.singularity.data.network.response.GeoResponse
import kz.singularity.domain.models.Geo

class GeoMapper {
    fun fromRemoteToDomain(geoResponse: GeoResponse): Geo {
        return Geo(
            lat = geoResponse.lat,
            lng = geoResponse.lng
        )
    }
}