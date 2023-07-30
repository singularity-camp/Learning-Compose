package kz.singularity.learningcompose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.theme.CustomTheme

@Composable
fun Photo(
    modifier: Modifier = Modifier,
    imgUrl:String,
    name:String,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(
            bottomStart = 8.dp,
            bottomEnd = 8.dp
        ),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                model = imgUrl,
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.img_developers),
                error = painterResource(id = R.drawable.img_developers)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = name,
                    style = CustomTheme.typography.h2,
                    color = CustomTheme.colors.text01
                )
            }
        }
    }
}