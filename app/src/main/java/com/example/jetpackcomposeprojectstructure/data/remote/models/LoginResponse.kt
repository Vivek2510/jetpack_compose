package com.example.jetpackcomposeprojectstructure.data.remote.models

data class LoginResponse(
    val userId: Long,
    val username: String,
    val token: String
)