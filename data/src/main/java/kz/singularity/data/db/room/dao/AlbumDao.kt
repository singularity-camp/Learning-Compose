package kz.singularity.data.db.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dependencyinjection.data.db.room.entity.AlbumEntity
import com.example.dependencyinjection.data.db.room.entity.CommentEntity
import kz.singularity.data.db.room.entity.PostEntity


@Dao
interface AlbumDao {

    @Query("SELECT * FROM AlbumEntity")
    suspend fun getAllAlbums(): List<AlbumEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAlbums(albumEntity: List<AlbumEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAlbum(albumEntity: AlbumEntity)


}