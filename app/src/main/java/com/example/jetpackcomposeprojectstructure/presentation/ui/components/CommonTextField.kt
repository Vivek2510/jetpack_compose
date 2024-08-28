package com.example.jetpackcomposeprojectstructure.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    icon: Painter,
    isError: Boolean = false,
    singleLine: Boolean = true
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = value,
            label = { Text(text = label) },
            onValueChange = onValueChange,
            leadingIcon = {
                Image(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .height(height = 20.dp)
                        .width(width = 20.dp)
                )
            },
            placeholder = { Text(text = placeholder) },
            isError = isError,
            singleLine = singleLine,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(8.dp),
        )
    }
}