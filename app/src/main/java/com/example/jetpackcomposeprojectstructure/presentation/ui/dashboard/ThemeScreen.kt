
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeprojectstructure.ThemeManager
import com.example.jetpackcomposeprojectstructure.presentation.ui.theme.LocalCustomColors
import com.example.jetpackcomposeprojectstructure.presentation.ui.theme.MyAppTheme

@Composable
fun ThemeScreen() {
//    var isDarkTheme by remember { mutableStateOf(App.isDarkTheme) }

    MyAppTheme {
        val customColors = LocalCustomColors.current

        Column(
            modifier = Modifier
                .background(customColors.customBackground) // Use custom background color
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
//                    isDarkTheme = !isDarkTheme

                    ThemeManager.isDarkTheme = !ThemeManager.isDarkTheme
                },
            ) {
                Text(
                    text = if (ThemeManager.isDarkTheme) "Switch to Light Theme" else "Switch to Dark Theme",
                    color = customColors.customOnSurface // Use custom onSurface color
                )
            }
        }
    }
}
