package com.example.jetpackcomposeprojectstructure.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackcomposeprojectstructure.data.local.dao.UserDao
import com.example.jetpackcomposeprojectstructure.data.local.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}