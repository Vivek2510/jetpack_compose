package com.example.jetpackcomposeprojectstructure.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme


// Define light and dark color schemes
private val LightColors = lightColorScheme(
    primary = LightColorPalette.primary,
    background = LightColorPalette.background,
)

private val DarkColors = darkColorScheme(
    primary = DarkColorPalette.primary,
    background = LightColorPalette.background,
)
@Composable
fun MyAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = MyTypography,
        shapes = Shapes,
        content = content
    )
}