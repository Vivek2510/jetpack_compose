package com.example.jetpackcomposeprojectstructure.data.remote.api

import com.example.jetpackcomposeprojectstructure.data.remote.models.LoginResponse
import com.example.jetpackcomposeprojectstructure.data.remote.models.ObjectResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("login")
    suspend fun login(@Query("username") username: String, @Query("password") password: String): Response<LoginResponse>

    @GET("objects")
    suspend fun getObjects(): Response<List<ObjectResponse>>
}