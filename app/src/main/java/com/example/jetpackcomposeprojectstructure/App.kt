package com.example.jetpackcomposeprojectstructure

import android.annotation.SuppressLint
import android.app.Application
import androidx.navigation.NavHostController

class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        var navHostController: NavHostController? = null
    }
}