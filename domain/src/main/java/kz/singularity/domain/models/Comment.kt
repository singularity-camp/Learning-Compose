package kz.singularity.domain.models

data class Comment(
    val body: String,
    val email: String,
    val id: Long,
    val name: String,
    val postId: Long
)