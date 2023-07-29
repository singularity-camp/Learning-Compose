package kz.singularity.learningcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable


@Composable
fun CustomTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    CompositionLocalProvider {
        LocalColors provides CustomTheme.colors
        LocalTypography provides CustomTheme.typography
    }

    MaterialTheme(
//        colors = colors,
        content = content,

//        typography = Typography
    )
}

