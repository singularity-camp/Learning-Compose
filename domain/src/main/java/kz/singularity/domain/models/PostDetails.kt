package kz.singularity.domain.models

import org.w3c.dom.Comment

data class PostDetails(
    val body: String,
    val id: Long,
    val title: String,
    val userId: Long,
    val username: String,
    val comments: List<Comment>
)