package kz.singularity.domain.models


data class PostDetails(
    val body: String,
    val id: Long,
    val title: String,
    val userId: Long,
    val username: String,
    val comments: List<Comment>
)