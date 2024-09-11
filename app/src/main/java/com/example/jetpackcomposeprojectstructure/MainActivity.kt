package com.example.jetpackcomposeprojectstructure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeprojectstructure.presentation.ui.main.MainViewModel
import com.example.jetpackcomposeprojectstructure.presentation.ui.navigation.AppNavigation
import com.example.jetpackcomposeprojectstructure.presentation.ui.theme.MyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val user by mainViewModel.user.collectAsState()
            val isLoading by mainViewModel.isLoading.collectAsState()
            MyAppTheme {
                if (isLoading) {
                    LoadingScreen()
                } else {
                    AppNavigation(user)
                }
            }
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(14.dp)
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(100.dp)
                    .background(
                        Color.Gray.copy(alpha = 0.1f),
                        shape = CircleShape
                    )
                    .padding(16.dp)
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        ) {
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
        }
    }
}


