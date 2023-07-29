package kz.singularity.learningcompose.di

import kz.singularity.learningcompose.models.PostUI
import kz.singularity.learningcompose.ui.main.MainViewModel
import kz.singularity.learningcompose.ui.post_detail.PostDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get()) }
    viewModel { (post: PostUI) -> PostDetailViewModel(post, get(), get()) }
}