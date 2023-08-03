package kz.singularity.learningcompose.ui.albums

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.views.PhotoCard
import org.koin.androidx.compose.get

@Composable
fun AlbumsPhotosPage(
    albumId: Long,
    albumName: String,
    usernameOfAlbum: String,
    viewModel: AlbumsViewModel = get()
) {
    viewModel.getPhotosFromAlbum(albumId)
    val photos = viewModel.photosFromAlbum

    var viewMode by remember { mutableStateOf(ViewMode.List) }
    val listIcon = painterResource(R.drawable.ic_list)
    val gridIcon = painterResource(R.drawable.ic_grid)

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = albumName,
            style = MaterialTheme.typography.h1,
            color = CustomTheme.colors.text01
        )
        Spacer(modifier = Modifier.size(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = usernameOfAlbum,
                style = MaterialTheme.typography.button,
                color = CustomTheme.colors.main01
            )
            IconButton(
                onClick = { viewMode = viewMode.toggle() }
            ) {
                Icon(
                    painter = if (viewMode == ViewMode.List) listIcon else gridIcon,
                    contentDescription = "Toggle View Mode"
                )
            }
        }
        Spacer(modifier = Modifier.size(16.dp))

        if (viewMode == ViewMode.List) {
            LazyColumn(
                //contentPadding = PaddingValues(16.dp),
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
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                //contentPadding = PaddingValues(8.dp),
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


enum class ViewMode {
    List,
    Grid;

    fun toggle(): ViewMode = when (this) {
        List -> Grid
        Grid -> List
    }
}