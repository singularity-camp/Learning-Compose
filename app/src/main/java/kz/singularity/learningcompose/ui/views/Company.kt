package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.theme.CustomTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CompanyCard(
    companyName: String,
    fullName: String,
    service: String
) {
    Card(
        backgroundColor = CustomTheme.colors.ui01,
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CompanyNameStyle(companyName = companyName)
            FullNameStyle(fullName = fullName)
            ServiceStyle(s = service)
        }
    }
}

@Composable
fun CompanyNameStyle(companyName: String) {
    Row {
        Text(
            text = stringResource(id = R.string.company_name) + ":",
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text02
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = companyName,
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text01
        )
    }
}

@Composable
fun ServiceStyle(s: String) {
    Row {
        Text(
            text = stringResource(id = R.string.business_services) + ":",
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text02
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = s,
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text01
        )
    }
}

