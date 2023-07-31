package kz.singularity.data.network.response


import com.google.gson.annotations.SerializedName

data class CompanyResponse(
    @SerializedName("bs")
    val bs: String,
    @SerializedName("catchPhrase")
    val catchPhrase: String,
    @SerializedName("name")
    val name: String
)