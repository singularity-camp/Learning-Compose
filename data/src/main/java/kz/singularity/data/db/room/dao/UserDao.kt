package kz.singularity.data.db.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kz.singularity.data.db.room.entity.UserEntity

@Dao
interface UserDao{
    @Query("Select * From UserEntity")
    suspend fun getUser(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(userEntity: List<UserEntity>)

}