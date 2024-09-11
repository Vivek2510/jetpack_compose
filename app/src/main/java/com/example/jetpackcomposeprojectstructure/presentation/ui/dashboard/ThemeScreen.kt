import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeprojectstructure.presentation.ui.theme.LocalCustomColors
import com.example.jetpackcomposeprojectstructure.presentation.ui.theme.MyAppTheme

@Composable
fun ThemeScreen() {
    var isDarkTheme by remember { mutableStateOf(false) }

    MyAppTheme(darkTheme = isDarkTheme) {
        val customColors = LocalCustomColors.current

        Column(
            modifier = Modifier
                .background(customColors.myColor) // Use custom background color
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello, World!",
                color = customColors.customOnBackground, // Use custom onBackground color
                fontSize = 28.sp
            )
            Button(
                onClick = {
                    isDarkTheme = !isDarkTheme
                },
            ) {
                Text(
                    text = if (isDarkTheme) "Switch to Light Theme" else "Switch to Dark Theme",
                    color = customColors.customOnSurface // Use custom onSurface color
                )
            }
        }
    }
}
