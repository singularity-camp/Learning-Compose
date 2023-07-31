package kz.singularity.domain.models


data class User(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Long,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)