package com.example.jetpackcomposeprojectstructure.domain.usercas

import com.example.jetpackcomposeprojectstructure.domain.model.User
import com.example.jetpackcomposeprojectstructure.domain.repository.UserRepository

class LoginUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String, password: String): User {
        return userRepository.login(username, password)
    }
}