package kz.singularity.learningcompose.ui.views

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.ui.theme.CustomTheme

@Composable
fun InfoSnippet(
    modifier: Modifier = Modifier,
    @StringRes label: Int,
    value: String,
    onClick: () -> Unit,
    textStyle: TextStyle = CustomTheme.typography.h4,
    labelColor: Color = CustomTheme.colors.text02,
    valueColor: Color = CustomTheme.colors.link,
) {
    Row(modifier = modifier) {
        Text(
            text = stringResource(id = label) + ":",
            style = textStyle,
            color = labelColor
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            modifier = Modifier.clickable { onClick() },
            text = value,
            style = textStyle,
            color = valueColor
        )
    }
}

@Composable
fun InfoSnippet(
    modifier: Modifier = Modifier,
    @StringRes label: Int,
    value: String,
    textStyle: TextStyle = CustomTheme.typography.h4,
    labelColor: Color = CustomTheme.colors.text02,
    valueColor: Color = CustomTheme.colors.text01,
) {
    Row(modifier = modifier) {
        Text(
            text = stringResource(id = label) + ":",
            style = textStyle,
            color = labelColor
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = value,
            style = textStyle,
            color = valueColor
        )
    }
}