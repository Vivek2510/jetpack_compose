package com.example.jetpackcomposeprojectstructure.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeprojectstructure.App
import com.example.jetpackcomposeprojectstructure.domain.model.User
import com.example.jetpackcomposeprojectstructure.presentation.ui.dashboard.DashboardScreen
import com.example.jetpackcomposeprojectstructure.presentation.ui.lrf.login.LoginScreen

@Composable
fun AppNavigation(user: User?) {
    val navController = rememberNavController()
    App.navHostController = navController

    NavHost(
        navController,
        startDestination = if (user == null) Routes.loginScreen else Routes.dashboard
    ) {
        composable(Routes.loginScreen) { LoginScreen(navController) }
        composable(Routes.dashboard) { DashboardScreen() }
    }
}