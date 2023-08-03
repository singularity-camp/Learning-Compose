package kz.singularity.learningcompose.di

import kz.singularity.domain.models.Post
import kz.singularity.learningcompose.ui.albums.AlbumsViewModel
import kz.singularity.learningcompose.ui.main.MainViewModel
import kz.singularity.learningcompose.ui.main.postDetailedViewModel
import kz.singularity.learningcompose.ui.users.UserPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get(), get(), get(), get()) }
    viewModel { postDetailedViewModel(get(), get(), get()) }
    viewModel {AlbumsViewModel(get(), get(), get())}
    viewModel { UserPageViewModel(get(), get()) }
}