package io.mishkav.jnicalculatorsample.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
    primary = Purple200,
    onPrimary = Color.Black,
    secondary = Teal200,

    background = Color.White
)

private val LightColorPalette = lightColorScheme(
    primary = Purple500,
    onPrimary = Color.Black,
    secondary = Teal200,

    background = Color.White
)

@Composable
fun JNICalculatorSampleTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        content = content
    )
}