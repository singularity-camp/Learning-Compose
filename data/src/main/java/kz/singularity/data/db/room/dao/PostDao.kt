package kz.singularity.data.db.room.dao

import androidx.room.*
import kz.singularity.data.db.room.entity.PostEntity

@Dao
interface PostDao {

    @Query("SELECT * FROM PostEntity")
    suspend fun getAllPosts(): List<PostEntity>

    @Query("SELECT * FROM PostEntity WHERE id = :id LIMIT 1")
    suspend fun getPost(id: Long): PostEntity

    /*@Query("SELECT * FROM PostEntity WHERE userId = :userId")
    suspend fun getUserPosts(userId: Long): List<PostEntity>*/

    @Query("SELECT userId FROM PostEntity WHERE userId = :userId")
    suspend fun getUserIdFromPost(userId: Long): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPost(postEntity: PostEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPosts(postEntities: List<PostEntity>)

    @Delete
    suspend fun deletePost(post: PostEntity)

}