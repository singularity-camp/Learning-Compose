package kz.singularity.learningcompose.di

import kz.singularity.domain.models.Post
import kz.singularity.learningcompose.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get(), get(), get()) }
   // viewModel { (post: Post) -> postDetailedViewModel(get(), get(), post = post) }
}