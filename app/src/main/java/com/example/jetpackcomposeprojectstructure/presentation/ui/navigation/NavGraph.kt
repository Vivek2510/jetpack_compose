package com.example.jetpackcomposeprojectstructure.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposeprojectstructure.presentation.ui.dashboard.ApiDemo
import com.example.jetpackcomposeprojectstructure.presentation.ui.dashboard.LanguageScreen
import com.example.jetpackcomposeprojectstructure.presentation.ui.dashboard.ThemeScreen

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = "Language", modifier = modifier) {
        composable("Language") { LanguageScreen(navController) }
        composable("Theme") { ThemeScreen() }
        composable("Api") { ApiDemo() }
    }
}


