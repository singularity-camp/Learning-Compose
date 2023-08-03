package kz.singularity.data.network.response


import com.google.gson.annotations.SerializedName

data class TodoResponse(
    @SerializedName("completed")
    val completed: Boolean,
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Long
)