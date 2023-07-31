package kz.singularity.data.network.response


import com.google.gson.annotations.SerializedName

data class GeoResponse(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String
)