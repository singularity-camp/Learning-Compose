package kz.singularity.learningcompose.di

import kz.singularity.domain.use_cases.GetAlbumsUseCase
import kz.singularity.domain.use_cases.GetCommentsUseCase
import kz.singularity.domain.use_cases.GetPhotosUseCase
import kz.singularity.domain.use_cases.GetTodosUseCase
import kz.singularity.domain.use_cases.GetUsersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { kz.singularity.domain.use_cases.GetPostsUseCase(get()) }
    factory { kz.singularity.domain.use_cases.GetPostDetailsUseCase(get()) }
    factory { GetCommentsUseCase(get()) }
    factory { GetUsersUseCase(get()) }
    factory { GetAlbumsUseCase(get()) }
    factory { GetPhotosUseCase(get()) }
    factory { GetTodosUseCase(get()) }
}