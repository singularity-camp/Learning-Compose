package kz.singularity.learningcompose.ui.albums

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kz.singularity.learningcompose.navigation.Destinations
import kz.singularity.learningcompose.ui.views.Album
import org.koin.androidx.compose.get

@Composable
fun AlbumsPage(navController: NavController, viewModel: AlbumsViewModel = get()) {
    val albums = viewModel.album

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(albums.size) { index ->
            val album = albums[index]
            val username = viewModel.getUserById(album.userId)
            viewModel.getPhotosFromAlbum(album.id)
            val photo = viewModel.getPhotoFromList(albumId = album.id)

            if (photo != null && username != null) {
                Album(
                    fontUrl = photo.url,
                    albumName = album.title,
                    usernameOfAlbum = username.username,
                    onClick = {
                        navController.navigate(
                            Destinations.PhotosFromAlbum.createRoute(
                                album.id,
                                album.title,
                                username.username
                            )
                        )
                    }
                )
            }
        }
    }

}