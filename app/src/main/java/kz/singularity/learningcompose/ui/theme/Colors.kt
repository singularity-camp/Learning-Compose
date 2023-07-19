package kz.singularity.learningcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

public val DarkColorPalette = darkColors(
    surface = Color.Red,
    primary = Color(0xFFFFA500),
    onPrimary = Color.DarkGray
)

public val LightColorPalette = lightColors(
    surface = Color.Red,
    primary = Color(0xFFFFA5FF),
    onPrimary = Color.DarkGray
)


