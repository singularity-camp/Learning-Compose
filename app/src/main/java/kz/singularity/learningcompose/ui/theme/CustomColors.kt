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

val main_01 = Color(0xFFE61771)
val main_02 = Color(0xFF394F62)
val text_01 = Color(0xFF000000)
val text_02 = Color(0xFF979797)
val ui_01 = Color(0xFFFFFFFF)
val ui_02 = Color(0xFFF7F7F7)
val ui_03 = Color(0xFFEDEDEF)
val ui_04 = Color(0xFFE3E2E7)
val ui_05 = Color(0xFFC0BDCB)
val links = Color(0xFF0075CD)

@Immutable
data class CustomColors(
    val main01: Color,
    val main02: Color,
    val ui01: Color,
    val ui02: Color,
    val ui03: Color,
    val ui04: Color,
    val ui05: Color,
    val text01: Color,
    val text02: Color,
    val links: Color
)

val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(
        ui01 = ui_01,
        ui02 = ui_02,
        ui03 = ui_03,
        ui04 = ui_04,
        ui05 = ui_05,
        text01 = text_01,
        text02 = text_02,
        links = links,
        main01 = main_01,
        main02 = main_02
    )
}