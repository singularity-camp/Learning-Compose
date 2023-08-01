package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.ui.theme.CustomTheme

@Composable
fun TaskCard(
    modifier: Modifier,
    taskName: String,
    checked: Boolean,
    onCheckedChange: () -> Unit
) {
    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = taskName,
                color = CustomTheme.colors.text01,
                style = CustomTheme.typography.h2
            )
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                modifier = Modifier.size(24.dp),
                checked = checked,
                onCheckedChange = { onCheckedChange() },
                colors = CheckboxDefaults.colors(checkedColor = CustomTheme.colors.main01)
            )
        }
    }
}