package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.layout.*
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
/*
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
*/

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserCard(
    username: String,
    userEmail: String,
    name: String,
    onClick: () -> Unit
) {
    Card(
        backgroundColor = CustomTheme.colors.ui01,
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            /*.placeholder(
                visible = true,
                highlight = PlaceholderHighlight.shimmer(),
            ),*/,
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = username,
                style = MaterialTheme.typography.h2,
                color = CustomTheme.colors.text01
            )
            Spacer(modifier = Modifier.size(24.dp))
            FullNameStyle(fullName = name)
            Spacer(modifier = Modifier.size(16.dp))
            Email(email = userEmail)
        }
    }
}

@Composable
fun FullNameStyle(fullName: String) {
    Row {
        Text(
            text = stringResource(id = R.string.fullname) + ":",
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text02
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = fullName,
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text01)
    }
}
