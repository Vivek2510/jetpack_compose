package com.example.jetpackcomposeprojectstructure.domain.repository

import com.example.jetpackcomposeprojectstructure.domain.model.ObjectDomain
import com.example.jetpackcomposeprojectstructure.domain.model.User

interface UserRepository {
    suspend fun login(username: String, password: String): User
    suspend fun getObjects(): List<ObjectDomain>
}