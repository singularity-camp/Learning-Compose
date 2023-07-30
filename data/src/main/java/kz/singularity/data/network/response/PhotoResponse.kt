package kz.singularity.data.network.response


import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("albumId")
    val albumId: Long,
    @SerializedName("id")
    val id: Long,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)