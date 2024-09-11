package com.example.jetpackcomposeprojectstructure.presentation.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackcomposeprojectstructure.App
import com.example.jetpackcomposeprojectstructure.R
import com.example.jetpackcomposeprojectstructure.localization.updateLocale
import com.example.jetpackcomposeprojectstructure.presentation.ui.main.MainViewModel
import com.example.jetpackcomposeprojectstructure.presentation.ui.navigation.Routes
import com.example.jetpackcomposeprojectstructure.presentation.ui.theme.LocalCustomColors
import com.example.jetpackcomposeprojectstructure.presentation.ui.theme.MyAppTheme
import java.util.Locale

@Composable
fun LanguageScreen() {
    // Get the MainViewModel using Hilt
    val viewModel: MainViewModel = hiltViewModel()

    val (locale, setLocale) = rememberSaveable { mutableStateOf(Locale.getDefault()) }
    val context = LocalContext.current
    val customColors = LocalCustomColors.current


    MyAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = customColors.customBackground)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 72.dp), // Ensure padding to avoid overlap with FAB
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.greeting),
                    style = MaterialTheme.typography.titleLarge,
                            color = customColors.customOnSurface
                )

                Button(
                    onClick = {
                        val newLocale = Locale("en")
                        setLocale(newLocale)
                        updateLocale(context, newLocale)
                    }
                ) {
                    Text(text = "Change to English")
                }
                Button(
                    onClick = {
                        val newLocale = Locale("fr")
                        setLocale(newLocale)
                        updateLocale(context, newLocale)
                    }
                ) {
                    Text(text = "Change to French")
                }
                Button(
                    onClick = {
                        val newLocale = Locale("es")
                        setLocale(newLocale)
                        updateLocale(context, newLocale)
                    }
                ) {
                    Text(text = "Change to Spanish")
                }
            }

            FloatingActionButton(
                onClick = {
                    // Handle logout action
                    viewModel.logout()  // Clear local data
                    navigateToLoginPage()
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text("Logout", color = customColors.customOnSurface )
            }
        }
    }
}

fun navigateToLoginPage() {
    val navController = App.navHostController
    navController?.navigate(Routes.loginScreen) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }
}