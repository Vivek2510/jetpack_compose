package com.example.jetpackcomposeprojectstructure

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController

class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        var navHostController: NavHostController? = null
    }

}


object ThemeManager {
    // Global mutable state for dark theme
    var isDarkTheme by mutableStateOf(false)
}