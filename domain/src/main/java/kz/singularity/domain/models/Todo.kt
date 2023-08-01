package kz.singularity.domain.models


data class Todo(
    val completed: Boolean,
    val id: Long,
    val title: String,
    val userId: Long
)