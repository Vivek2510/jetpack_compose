package com.example.jetpackcomposeprojectstructure.data.repository

import com.example.jetpackcomposeprojectstructure.data.local.dao.UserDao
import com.example.jetpackcomposeprojectstructure.data.local.entities.UserEntity
import com.example.jetpackcomposeprojectstructure.data.remote.api.ApiService
import com.example.jetpackcomposeprojectstructure.domain.model.ObjectDomain
import com.example.jetpackcomposeprojectstructure.domain.model.User
import com.example.jetpackcomposeprojectstructure.domain.repository.UserRepository

class UserRepositoryImpl(
    private val apiService: ApiService,
    private val userDao: UserDao,
) : UserRepository {

    override suspend fun login(username: String, password: String): User {
//        val response = apiService.login(username, password)
//        if (response.isSuccessful) {
//            val body = response.body()!!
//            val userEntity = UserEntity(
//                id = body.userId,
//                username = body.username,
//                password = password // Ideally, store hashed passwords
//            )
//            userDao.insertUser(userEntity)
//            return User(userEntity.id, userEntity.username, userEntity.password)
//        } else {
//            throw Exception("Login failed")
//        }

        if (username.isNotEmpty()) {
            val userEntity = UserEntity(
                id = 1234685498498489,  // Replace with proper ID generation logic
                username = username,
                password = password // Ideally, store hashed passwords
            )
            userDao.insertUser(userEntity)

            // Retrieve the inserted user to ensure it was inserted properly
            val insertedUser = userDao.getUserById(userEntity.id)
            return if (insertedUser != null) {
                User(insertedUser.id, insertedUser.username, insertedUser.password)
            } else {
                throw Exception("Login failed: User not found after insertion")
            }
        } else {
            throw Exception("Login failed: Username is empty")
        }
    }


    override suspend fun getObjects(): List<ObjectDomain> {
        val response = apiService.getObjects()
        if (response.isSuccessful) {
            return response.body()?.map {
                ObjectDomain(
                    id = it.id,
                    name = it.name,
                    color = it.data?.color,
                    capacity = it.data?.capacity,
                    price = it.data?.price
                )
            } ?: emptyList()
        } else {
            throw Exception("Failed to fetch objects: ${response.message()}")
        }
    }
}