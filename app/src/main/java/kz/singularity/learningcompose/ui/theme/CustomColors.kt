package kz.singularity.learningcompose.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

//fun getColors(isDark: Boolean): CustomColors {
//    if (isDark) {
//        CustomColors(brand01 = Color(0xFFFFFFFF))
//    } else {
//        CustomColors(brand01 = Color(0xFFFFFFFF))
//    }
//}

@Immutable
data class CustomColors(
    val brand01: Color,
    val brand02: Color,
    val ui01: Color,
    val ui02: Color,
    val ui03: Color,
    val ui04: Color,
    val ui05: Color,
    val text01: Color,
    val text02: Color,
    val links: Color,
    val support01: Color,
    val support02: Color,
    val support03: Color,
    val support04: Color,
    val support05: Color,
)

val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(
        brand01 = Color.Unspecified,
        brand02 = Color.Unspecified,
        ui01 = Color.Unspecified,
        ui02 = Color.Unspecified,
        ui03 = Color.Unspecified,
        ui04 = Color.Unspecified,
        ui05 = Color.Unspecified,
        text01 = Color.Unspecified,
        text02 = Color.Unspecified,
        links = Color.Unspecified,
        support01 = Color.Unspecified,
        support02 = Color.Unspecified,
        support03 = Color.Unspecified,
        support04 = Color.Unspecified,
        support05 = Color.Unspecified,
    )
}