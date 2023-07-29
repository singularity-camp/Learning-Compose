package kz.singularity.learningcompose.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColors(
    val ui01: Color,
    val ui02: Color,
    val text01: Color,
    val text02: Color,
    val main01: Color,
    val link: Color
)

val LocalColors = staticCompositionLocalOf {
    CustomColors(
        ui01 = Color.White,
        ui02 = Color.Black,
        text01 = Color.Black,
        text02 = Color(0xFF979797),
        main01 = Color(0xFFE61771),
        link = Color(0xFF0075CD)
    )
}