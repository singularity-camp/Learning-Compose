package kz.singularity.data.db.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    @PrimaryKey
    val id: Long,
    val body: String,
    val title: String,
    val userId: Long,
)