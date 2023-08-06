package kz.singularity.learningcompose.di

import kz.singularity.learningcompose.ui.albums.AlbumsViewModel
import kz.singularity.learningcompose.ui.albums.PhotoViewModel
import kz.singularity.learningcompose.ui.posts.PostDetailedViewModel
import kz.singularity.learningcompose.ui.posts.PostsPageViewModel
import kz.singularity.learningcompose.ui.user_profile.ProfileViewModel
import kz.singularity.learningcompose.ui.user_profile.ToDoViewModel
import kz.singularity.learningcompose.ui.users.UserPageViewModel
import kz.singularity.learningcompose.ui.users.UserProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    //viewModel { MainViewModel(get(), get(), get(), get(), get()) }
    viewModel {AlbumsViewModel(get(), get(), get())}
    viewModel { UserPageViewModel(get()) }
    viewModel { PostsPageViewModel(get(), get()) }
    viewModel { PostDetailedViewModel(get(), get()) }
    viewModel { PhotoViewModel(get(), get()) }
    viewModel { UserProfileViewModel(get()) }
    viewModel { ProfileViewModel(get())}
    viewModel { ToDoViewModel(get(), get()) }
}