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
    val container:Color,
    val text_01:Color,
    val text_02:Color,
    val main_01:Color,

)

val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(
        container = Color.White,
        text_01 = Color.Black,
        text_02 = MountainMist,
        main_01 = PinkLemoned
    )
}