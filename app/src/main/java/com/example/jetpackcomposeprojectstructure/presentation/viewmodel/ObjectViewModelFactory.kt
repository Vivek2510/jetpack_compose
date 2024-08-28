package com.example.jetpackcomposeprojectstructure.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcomposeprojectstructure.domain.usercas.GetObjectsUseCase

class ObjectViewModelFactory(
    private val getObjectsUseCase: GetObjectsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ObjectViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ObjectViewModel(getObjectsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
