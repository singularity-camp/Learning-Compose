package kz.singularity.learningcompose.ui.albums

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kz.singularity.learningcompose.navigation.Destinations
import kz.singularity.learningcompose.ui.animation.LoadingShimmerEffect
import kz.singularity.learningcompose.ui.animation.ShimmerType
import kz.singularity.learningcompose.ui.views.AlbumCard
import org.koin.androidx.compose.get

@Composable
fun AlbumsPage(navController: NavController, viewModel: AlbumsViewModel = get()) {
    val albums = viewModel.album
    val albumIdToUsernameMap = viewModel.albumIdToUsernameMap
    val albumIdToFirstPhotoMap = viewModel.albumIdToFirstPhotoMap
    val isLoading = viewModel.isLoading

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(albums.size) { index ->
            val album = albums[index]
            val username = albumIdToUsernameMap[album.id]
            val photo = albumIdToFirstPhotoMap[album.id]

            if (isLoading.value) {
                LoadingShimmerEffect(shimmerType = ShimmerType.ALBUMS)
            } else {
                if (photo != null && username != null) {
                    AlbumCard(
                        fontUrl = photo.url,
                        albumName = album.title,
                        usernameOfAlbum = username,
                        onClick = {
                            navController.navigate(
                                Destinations.PhotosFromAlbum.createRoute(
                                    album.id,
                                    album.title,
                                    username
                                )
                            )
                        }
                    )
                }
            }
        }
    }

}