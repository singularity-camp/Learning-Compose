package kz.singularity.data.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import kz.singularity.data.db.room.dao.PostDao
import kz.singularity.data.db.room.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1)
abstract class AppRoomDatabase: RoomDatabase() {
    abstract fun postDao(): PostDao
}