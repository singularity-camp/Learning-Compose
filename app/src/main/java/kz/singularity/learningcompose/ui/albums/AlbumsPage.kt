package kz.singularity.learningcompose.ui.albums

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.models.AlbumUI
import kz.singularity.learningcompose.ui.views.Album
import org.koin.androidx.compose.getViewModel

@Composable
fun AlbumsPage(
    paddingValues: PaddingValues,
    onClick:(AlbumUI)->Unit
) {
    val viewModel:AlbumViewModel = getViewModel()
    val albums = viewModel.screenState.value

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(albums.size){
            val album = albums[it]
            Album(
                imgUrl = album.imgUrl,
                albumName = album.name,
                userName = album.userName,
                onClick = {onClick(album)}
            )
        }
    }
}