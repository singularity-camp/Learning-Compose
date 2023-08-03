package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.theme.CustomTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Album(
    fontUrl: String,
    albumName: String,
    usernameOfAlbum: String,
    onClick: () -> Unit
){
    Card(
        backgroundColor = CustomTheme.colors.ui01,
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,)
    {
        Column(modifier = Modifier.padding(16.dp)){
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth(),
                model = fontUrl,
                contentDescription = null,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = albumName,
                    style = MaterialTheme.typography.h2,
                    color = CustomTheme.colors.text01
                )
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = usernameOfAlbum,
                    style = typography.button,
                    color = CustomTheme.colors.main01
                )
            }
        }
    }
}