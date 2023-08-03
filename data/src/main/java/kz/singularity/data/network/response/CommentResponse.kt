package kz.singularity.data.network.response


import com.google.gson.annotations.SerializedName

data class CommentResponse(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("postId")
    val postId: Long,
    @SerializedName("email")
    val email: String,
)