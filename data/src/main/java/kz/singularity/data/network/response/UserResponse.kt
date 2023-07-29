package kz.singularity.data.network.response


import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("address")
    val address: AddressResponse,
    @SerializedName("company")
    val company: CompanyResponse,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String
)