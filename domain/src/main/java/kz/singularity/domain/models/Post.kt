package kz.singularity.domain.models

data class Post(
    val body: String,
    val id: Long,
    val title: String,
    val userId: Long
)