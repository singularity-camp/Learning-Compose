package kz.singularity.learningcompose.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class CustomTypography(
    val h1: TextStyle,
    val h2: TextStyle,
//    val h3: TextStyle,
    val h4: TextStyle,
//    val h5: TextStyle,
//    val h6: TextStyle,
//    val subtitle1: TextStyle,
//    val subtitle2: TextStyle,
    val body1: TextStyle,
//    val body2: TextStyle,
    val button: TextStyle,
//    val caption: TextStyle,
//    val overline: TextStyle
)

val LocalTypography = staticCompositionLocalOf {
    CustomTypography(
        h1 = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        ),
        h2 = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        ),
        h4 = TextStyle(
            fontSize = 16.sp
        ),
        body1 = TextStyle(
            fontSize = 16.sp,
        ),
        button = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )


    )
}
