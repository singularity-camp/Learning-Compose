package kz.singularity.data.db.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kz.singularity.domain.models.Address
import kz.singularity.domain.models.Company
import kz.singularity.domain.models.Geo

@Entity
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val email: String,
    val name: String,
    val phone: String,
    val username: String,
    val website: String,
    /*val company: Company,
    val address: Address*/
)