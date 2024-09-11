package com.example.jetpackcomposeprojectstructure.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Custom color scheme to use your own color names
data class CustomColorScheme(
    val customPrimary: Color,
    val customBackground: Color,
    val customOnBackground: Color,
    val customSurface: Color,
    val customOnSurface: Color,
    val myColor: Color,
)

// Define composition locals for the custom color scheme
val LocalCustomColors = staticCompositionLocalOf {
    CustomColorScheme(
        customPrimary = Color.Unspecified,
        customBackground = Color.Unspecified,
        customOnBackground = Color.Unspecified,
        customSurface = Color.Unspecified,
        customOnSurface = Color.Unspecified,
        myColor = Color.Unspecified
    )
}

@Composable
fun MyAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val customColors = if (darkTheme) {
        CustomColorScheme(
            customPrimary = CustomPrimaryDark,
            customBackground = CustomBackgroundDark,
            customOnBackground = CustomOnBackgroundDark,
            customSurface = CustomSurfaceDark,
            customOnSurface = CustomOnSurfaceDark,
            myColor = MyColorDark
        )
    } else {
        CustomColorScheme(
            customPrimary = CustomPrimaryLight,
            customBackground = CustomBackgroundLight,
            customOnBackground = CustomOnBackgroundLight,
            customSurface = CustomSurfaceLight,
            customOnSurface = CustomOnSurfaceLight,
            myColor = MyColorLight,
        )
    }

    CompositionLocalProvider(LocalCustomColors provides customColors) {
        MaterialTheme(
            typography = MyTypography,
            shapes = Shapes,
            content = content
        )
    }
}
