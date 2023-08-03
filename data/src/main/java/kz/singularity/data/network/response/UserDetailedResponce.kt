package kz.singularity.data.network.response

import com.google.gson.annotations.SerializedName
import org.w3c.dom.Comment

data class UserDetailedResponse (

    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("body")
    val body: String,

    val postId: Long,
    val title: String,
    val userId: Long,

    val comments: List<Comment>

)