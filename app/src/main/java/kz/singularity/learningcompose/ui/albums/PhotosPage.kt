package kz.singularity.learningcompose.ui.albums

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kz.singularity.domain.models.Photo
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.posts.Title
import kz.singularity.learningcompose.ui.animation.LoadingShimmerEffect
import kz.singularity.learningcompose.ui.animation.ShimmerType
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.views.PhotoCard
import org.koin.androidx.compose.get

@Composable
fun PhotosPage(
    albumId: Long,
    albumName: String,
    usernameOfAlbum: String,
    viewModel: PhotoViewModel = get()
) {
    val photos = viewModel.albumIdToPhotosMap[albumId]
    val isLoading = viewModel.isLoading
    val listIcon = painterResource(R.drawable.ic_list)
    val gridIcon = painterResource(R.drawable.ic_grid)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Title(title = albumName)
        Spacer(modifier = Modifier.size(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = usernameOfAlbum,
                style = MaterialTheme.typography.button,
                color = CustomTheme.colors.main01
            )
            IconButton(
                onClick = { viewModel.toggleViewMode() }
            ) {
                Icon(
                    painter = if (viewModel.viewMode == PhotoViewModel.ViewMode.List) listIcon else gridIcon,
                    contentDescription = "Toggle View Mode"
                )
            }
        }
        Spacer(modifier = Modifier.size(16.dp))

        if (isLoading.value) {
            LazyColumn() {
                items(5) {
                    LoadingShimmerEffect(shimmerType = ShimmerType.ALBUMS)
                }
            }
        } else if (photos != null) {
            DisplayPhotos(photos, viewModel.viewMode)
        }
    }
}

@Composable
private fun DisplayPhotos(photos: List<Photo>, viewMode: PhotoViewModel.ViewMode) {
    when (viewMode) {
        PhotoViewModel.ViewMode.List -> {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(photos.size) {
                    val photo = photos[it]

                    PhotoCard(
                        modifier = Modifier.height(IntrinsicSize.Max),
                        imgUrl = photo.url,
                        name = photo.title
                    )
                }
            }
        }

        PhotoViewModel.ViewMode.Grid -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(photos.size) {
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
}
