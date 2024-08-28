package com.example.jetpackcomposeprojectstructure.presentation.ui.main

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeprojectstructure.data.local.dao.UserDao
import com.example.jetpackcomposeprojectstructure.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userDao: UserDao,
    application: Application,
) : ViewModel() {

    private val context: Context = application.applicationContext

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    private val _isLoading = MutableStateFlow(true) // Initial state is loading
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchUserData()
    }

    private fun fetchUserData() {
        viewModelScope.launch {
            kotlinx.coroutines.delay(2000)

            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
            val userId = sharedPreferences.getLong("user_id", -1)

            if (userId != -1L) {
                val userEntity = userDao.getUserById(userId)
                _user.value = userEntity?.let {
                    User(it.id, it.username, it.password)
                }
            }

            _isLoading.value = false
        }
    }

    fun logout() {
        viewModelScope.launch {
            // Clear user data from the local database
            userDao.deleteAllUsers()

            // Clear user data from SharedPreferences
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                clear() // Clear all data
                apply() // Apply changes asynchronously
            }

            // Perform additional logout logic if needed, such as navigating to the login screen
        }
    }
}
