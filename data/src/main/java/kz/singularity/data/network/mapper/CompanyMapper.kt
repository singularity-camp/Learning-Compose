package kz.singularity.data.network.mapper

import kz.singularity.data.network.response.CompanyResponse
import kz.singularity.domain.models.Company

internal class CompanyMapper {

    fun fromRemoteToDomain(companyResponse: CompanyResponse): Company {
        return Company(
            bs = companyResponse.bs,
            catchPhrase = companyResponse.catchPhrase,
            name = companyResponse.name
        )
    }
}