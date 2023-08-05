package kz.singularity.data.network.response


import com.google.gson.annotations.SerializedName

data class AddressResponse(
    @SerializedName("city")
    val city: String,
    @SerializedName("geo")
    val geo: GeoResponse,
    @SerializedName("street")
    val street: String,
    @SerializedName("suite")
    val suite: String,
    @SerializedName("zipcode")
    val zipcode: String
)