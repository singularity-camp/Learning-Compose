package kz.singularity.learningcompose.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object CustomTheme {
    val colors: CustomColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: CustomTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}