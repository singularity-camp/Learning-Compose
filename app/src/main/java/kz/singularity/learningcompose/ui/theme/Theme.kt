package kz.singularity.learningcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


@Composable
fun CustomTheme(isDark: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    CompositionLocalProvider {
        //LocalCustomColors provides getColors(isDark)
    }

    MaterialTheme(
        colors = colors,
        content = content
    )
}

object CustomTheme {
    val colors: CustomColors
        @Composable
        get() = LocalCustomColors.current
}