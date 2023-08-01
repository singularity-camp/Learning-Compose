package kz.singularity.learningcompose.ui.photos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kz.singularity.domain.models.Photo
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.models.AlbumUI
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.views.PhotoCard
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun PhotosPage(
    album: AlbumUI,
    paddingValues: PaddingValues
) {
    val viewModel: PhotosViewModel = getViewModel { parametersOf(album) }

    when (val curState = viewModel.screenState.value) {
        PhotosScreenState.Initial -> {}
        PhotosScreenState.Loading -> {}
        is PhotosScreenState.Photos -> {
            PhotosContent(
                isGrid = curState.isGrid,
                photos = curState.photos,
                paddingValues = paddingValues,
                albumName = curState.albumName,
                userName = curState.userName,
                onClick = viewModel::changeState
            )
        }
    }

}

@Composable
private fun PhotosContent(
    albumName: String,
    userName: String,
    isGrid: Boolean,
    photos: List<Photo>,
    paddingValues: PaddingValues,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .padding(top = 32.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = albumName,
            style = CustomTheme.typography.h1,
            color = CustomTheme.colors.text01
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = userName,
                style = CustomTheme.typography.button,
                color = CustomTheme.colors.main01
            )

            IconButton(onClick = { onClick() }) {
                Icon(
                    painter = painterResource(id = if (isGrid) R.drawable.ic_list else R.drawable.ic_grid),
                    contentDescription = null,
                    tint = CustomTheme.colors.main01
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(top = 8.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                count = photos.size,
                span = { GridItemSpan(if (isGrid) 1 else maxLineSpan) },

            ) {
                val photo = photos[it]
                PhotoCard(
                    modifier = Modifier.height(IntrinsicSize.Max),
                    imgUrl = photo.url,
                    name = photo.title
                )
            }
        }

    }
}