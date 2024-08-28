package com.example.jetpackcomposeprojectstructure.presentation.ui.lrf.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.jetpackcomposeprojectstructure.R
import com.example.jetpackcomposeprojectstructure.presentation.ui.components.CommonButton
import com.example.jetpackcomposeprojectstructure.presentation.ui.components.CustomTextField
import com.example.jetpackcomposeprojectstructure.presentation.ui.components.LoadingIndicator
import com.example.jetpackcomposeprojectstructure.presentation.ui.navigation.Routes
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {
    val username by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val context = LocalContext.current


    LaunchedEffect(Unit) {
        viewModel.loginResult.collectLatest { result ->
            when (result) {
                is LoginResult.Success -> {
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                    navController.navigate(Routes.dashboard) // Navigate to home screen
                }

                is LoginResult.Error -> {
                    Toast.makeText(context, "Login Failed: ${result.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTextField(
            value = username,
            onValueChange = { viewModel.onUsernameChange(it) },
            label = "Username",
            placeholder = "Username",
            icon = painterResource(id = R.drawable.user),
        )
        CustomTextField(
            value = password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = "Password",
            placeholder = "Password",
            icon = painterResource(id = R.drawable.unlock),
        )
        CommonButton(text = "Login", onClick = { viewModel.login(context) })
        if (isLoading) {
            LoadingIndicator()
        }
    }
}


