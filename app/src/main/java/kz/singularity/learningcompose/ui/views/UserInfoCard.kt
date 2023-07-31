package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.theme.CustomTheme

@Composable
fun UserInfoCard(
    modifier: Modifier = Modifier,
    email: String,
    fullName: String,
    phone: String,
    website: String,
    onEmailClick: () -> Unit,
    onWebsiteClick: () -> Unit
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
                label = R.string.email,
                value = email,
                onClick = onEmailClick
            )
            Spacer(modifier = Modifier.height(8.dp))
            InfoSnippet(
                label = R.string.full_name,
                value = fullName
            )
            Spacer(modifier = Modifier.height(8.dp))
            InfoSnippet(
                label = R.string.phone,
                value = phone,
                valueColor = CustomTheme.colors.main01
            )
            Spacer(modifier = Modifier.height(8.dp))
            InfoSnippet(
                label = R.string.website,
                value = website,
                onClick = onWebsiteClick
            )
        }
    }

}