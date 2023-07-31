package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.R

@Composable
fun CompanyCard(
    modifier: Modifier = Modifier,
    companyName: String,
    fullName: String,
    businessService: String
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
                label = R.string.company_name,
                value = companyName
            )
            Spacer(modifier = Modifier.height(8.dp))
            InfoSnippet(
                label = R.string.full_name,
                value = fullName
            )
            Spacer(modifier = Modifier.height(8.dp))
            InfoSnippet(
                label = R.string.business_services,
                value = businessService
            )
        }
    }

}