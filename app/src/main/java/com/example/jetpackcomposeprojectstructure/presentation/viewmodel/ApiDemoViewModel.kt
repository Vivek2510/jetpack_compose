package com.example.jetpackcomposeprojectstructure.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeprojectstructure.domain.model.ObjectDomain
import com.example.jetpackcomposeprojectstructure.domain.usercas.GetObjectsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ObjectViewModel @Inject constructor(
    private val getObjectsUseCase: GetObjectsUseCase
) : ViewModel() {

    // State to manage objects data
    private val _objects = MutableStateFlow<List<ObjectDomain>>(emptyList())
    val objects: StateFlow<List<ObjectDomain>> get() = _objects

    // State to manage UI states (loading, success, error)
    private val _uiState = MutableStateFlow<ApiUiState>(ApiUiState.Loading)
    val uiState: StateFlow<ApiUiState> get() = _uiState

    init {
        fetchObjects()
    }

    private fun fetchObjects() {
        viewModelScope.launch {
            _uiState.value = ApiUiState.Loading
            try {
                val data = getObjectsUseCase() // Fetch data
                _objects.value = data
                _uiState.value = ApiUiState.Success
            } catch (e: Exception) {
                _uiState.value = ApiUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

// Sealed class for API UI state
sealed class ApiUiState {
    object Loading : ApiUiState()
    object Success : ApiUiState()
    data class Error(val message: String) : ApiUiState()
}
