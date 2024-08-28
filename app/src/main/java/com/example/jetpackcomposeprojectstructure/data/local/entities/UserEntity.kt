package com.example.jetpackcomposeprojectstructure.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: Long,
    val username: String,
    val password: String
)