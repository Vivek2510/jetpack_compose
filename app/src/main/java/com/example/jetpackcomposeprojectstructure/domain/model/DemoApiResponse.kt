package com.example.jetpackcomposeprojectstructure.domain.model


data class DemoApiResponse(
    val id: String,
    val name: String,
    val data: Data?
)

data class Data(
    val color: String?,
    val capacity: String?,
    val price: Double?,
    val generation: String?,
    val year: Int?,
    val CPUmodel: String?,
    val hardDiskSize: String?,
    val strapColour: String?,
    val caseSize: String?,
    val description: String?,
    val screenSize: Double?
)