package kz.singularity.domain.models

data class Todo(
    val userId: Long,
    val id: Long,
    val title: String,
    var completed: Boolean
)