package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.extensions.noRippleClickable
import kz.singularity.learningcompose.ui.theme.CustomTheme

@Composable
fun AddressCard(
    modifier: Modifier = Modifier,
    street: String,
    suite: String,
    city: String,
    zipCode: String,
    onMapClick: () -> Unit,
) {
    Card(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            InfoSnippet(
                label = R.string.street,
                value = street,
            )
            Spacer(modifier = Modifier.height(8.dp))
            InfoSnippet(
                label = R.string.suite,
                value = suite
            )
            Spacer(modifier = Modifier.height(8.dp))
            InfoSnippet(
                label = R.string.city,
                value = city,
            )
            Spacer(modifier = Modifier.height(8.dp))
            InfoSnippet(
                label = R.string.zip_code,
                value = zipCode,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .noRippleClickable { onMapClick() },
                text = stringResource(id = R.string.show_on_map),
                style = CustomTheme.typography.h2,
                color = CustomTheme.colors.link,
                textAlign = TextAlign.Center
            )
        }
    }

}