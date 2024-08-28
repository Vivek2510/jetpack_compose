package com.example.jetpackcomposeprojectstructure.presentation.ui.dashboard

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackcomposeprojectstructure.domain.model.ObjectDomain
import com.example.jetpackcomposeprojectstructure.presentation.ui.components.LoadingIndicator
import com.example.jetpackcomposeprojectstructure.presentation.viewmodel.ApiUiState
import com.example.jetpackcomposeprojectstructure.presentation.viewmodel.ObjectViewModel

@Composable
fun ApiDemo(viewModel: ObjectViewModel = hiltViewModel()) {
    val objects by viewModel.objects.collectAsState()
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(uiState) {
        when (uiState) {
            is ApiUiState.Success -> {
                Toast.makeText(context, "Data loaded successfully", Toast.LENGTH_SHORT).show()
            }

            is ApiUiState.Error -> {
                Toast.makeText(
                    context,
                    "Error: ${(uiState as ApiUiState.Error).message}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            else -> {
                Toast.makeText(context, "Data loading...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when (uiState) {
            is ApiUiState.Loading -> {
                LoadingIndicator()
            }

            is ApiUiState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ) {
                    items(objects) { obj ->
                        ObjectItem(objectDomain = obj)
                    }
                }
            }

            is ApiUiState.Error -> {
                // Optionally, show an error message or UI
            }
        }
    }
}

@Composable
fun ObjectItem(objectDomain: ObjectDomain) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .background(color = Color.LightGray, shape = CircleShape)
            .padding(horizontal = 10.dp, vertical = 15.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = objectDomain.name)
            objectDomain.color?.let { Text(text = it) }
        }
    }
}
