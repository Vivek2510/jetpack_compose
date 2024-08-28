package com.example.jetpackcomposeprojectstructure.domain.usercas

import com.example.jetpackcomposeprojectstructure.domain.model.ObjectDomain
import com.example.jetpackcomposeprojectstructure.domain.repository.UserRepository

class GetObjectsUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(): List<ObjectDomain> {
        return userRepository.getObjects()
    }
}