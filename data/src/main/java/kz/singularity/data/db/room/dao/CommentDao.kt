package kz.singularity.data.db.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dependencyinjection.data.db.room.entity.CommentEntity
import kz.singularity.data.db.room.entity.PostEntity


@Dao
interface CommentDao {

    @Query("SELECT * FROM CommentEntity")
    suspend fun getAllComments(): List<CommentEntity>
    @Query("Select * from CommentEntity Where postId = :id ")
    suspend fun getCommentsFromPost(id:Long): List<CommentEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addComments(commentEntity: List<CommentEntity>)


}