package com.example.dependencyinjection.data.db.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class AlbumEntity(
    @PrimaryKey
    val id: Long,
    val title: String,
    val userId: Long
)