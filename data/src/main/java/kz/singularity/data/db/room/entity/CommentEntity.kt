package com.example.dependencyinjection.data.db.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CommentEntity(
    @PrimaryKey
    val id: Long,
    val body: String,
    val email: String,
    val name: String,
    val postId: Long
)