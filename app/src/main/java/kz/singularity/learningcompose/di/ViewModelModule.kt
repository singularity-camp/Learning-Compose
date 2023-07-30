package kz.singularity.learningcompose.di

import kz.singularity.learningcompose.models.AlbumUI
import kz.singularity.learningcompose.models.PostUI
import kz.singularity.learningcompose.ui.albums.AlbumViewModel
import kz.singularity.learningcompose.ui.comments.CommentsViewModel
import kz.singularity.learningcompose.ui.main.MainViewModel
import kz.singularity.learningcompose.ui.photos.PhotosViewModel
import kz.singularity.learningcompose.ui.post_detail.PostDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get()) }
    viewModel { (post: PostUI) -> PostDetailViewModel(post, get(), get()) }
    viewModel { CommentsViewModel(get()) }
    viewModel { AlbumViewModel(get(), get()) }
    viewModel { (album: AlbumUI) -> PhotosViewModel(album, get()) }
}