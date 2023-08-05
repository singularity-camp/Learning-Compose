package kz.singularity.domain.models


data class PostDetails(
    val body: String,
    val title: String,
    val username: String?,
    val comments: List<Comment>
)