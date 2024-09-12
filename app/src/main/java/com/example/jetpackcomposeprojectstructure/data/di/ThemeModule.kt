package com.example.jetpackcomposeprojectstructure.data.di

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object ThemeManager {
    // Global mutable state for dark theme
    var isDarkTheme by mutableStateOf(false)
}