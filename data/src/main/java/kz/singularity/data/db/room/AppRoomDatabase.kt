package kz.singularity.data.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dependencyinjection.data.db.room.entity.AlbumEntity
import com.example.dependencyinjection.data.db.room.entity.CommentEntity
import kz.singularity.data.db.room.dao.AlbumDao
import kz.singularity.data.db.room.dao.CommentDao
import kz.singularity.data.db.room.dao.PostDao
import kz.singularity.data.db.room.dao.UserDao
import kz.singularity.data.db.room.entity.PostEntity
import kz.singularity.data.db.room.entity.UserEntity

@Database(
    entities = [PostEntity::class, CommentEntity::class, UserEntity::class, AlbumEntity::class],
    version = 4
)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun commentDao(): CommentDao
    abstract fun userDao(): UserDao
    abstract fun albumDao(): AlbumDao

}