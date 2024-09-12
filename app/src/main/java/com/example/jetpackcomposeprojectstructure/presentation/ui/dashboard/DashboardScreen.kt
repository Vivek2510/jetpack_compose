package com.example.jetpackcomposeprojectstructure.presentation.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeprojectstructure.presentation.ui.navigation.NavGraph

@Composable
fun DashboardScreen() {
    val navController = rememberNavController()
    var selectedButton by remember { mutableStateOf("Language") } // Default selected button

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    BottomBarButton("Language", selectedButton == "Language") {
                        selectedButton = "Language"
                        navController.navigate("language")
                    }
                    BottomBarButton("Theme", selectedButton == "Theme") {
                        selectedButton = "Theme"
                        navController.navigate("theme")
                    }
                    BottomBarButton("Api", selectedButton == "Api") {
                        selectedButton = "Api"
                        navController.navigate("api")
                    }
                }
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(innerPadding)
        ) {
            NavGraph(
                navController = navController,
            )
        }
    }
}

@Composable
fun BottomBarButton(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(color = if (isSelected) Color.Blue else Color.Gray, shape = CircleShape)
            .width(100.dp)
            .clickable(
                onClick = { onClick() },
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
            )
            .padding(10.dp)
    ) {
        Text(
            label,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
    }
}