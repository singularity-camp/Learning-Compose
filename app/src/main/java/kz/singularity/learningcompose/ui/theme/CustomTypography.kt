package kz.singularity.learningcompose.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class CustomTypography(
//    val h1: TextStyle,
    val h2: TextStyle,
//    val h3: TextStyle,
//    val h4: TextStyle,
//    val h5: TextStyle,
//    val h6: TextStyle,
//    val subtitle1: TextStyle,
//    val subtitle2: TextStyle,
    val body1: TextStyle,
//    val body2: TextStyle,
//    val button: TextStyle,
//    val caption: TextStyle,
//    val overline: TextStyle
)

val LocalCustomTypography = staticCompositionLocalOf {
    CustomTypography(
        h2 = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        ),
        body1 = TextStyle(
            fontSize = 16.sp,
            color = MountainMist
        )

    )
}
