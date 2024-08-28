package com.example.jetpackcomposeprojectstructure.data.remote.models

data class ObjectResponse(
    val id: String,
    val name: String,
    val data: ObjectData?
)

data class ObjectData(
    val color: String?,
    val capacity: String?,
    val price: Double?,
    val description: String?,
)