package kz.singularity.learningcompose.di

import kz.singularity.domain.use_cases.GetAlbumsUseCase
import kz.singularity.domain.use_cases.GetCommentsUseCase
import kz.singularity.domain.use_cases.GetPhotosByAlbumIdUseCase
import kz.singularity.domain.use_cases.GetPostCommentsUseCase
import kz.singularity.domain.use_cases.GetPostDetailsUseCase
import kz.singularity.domain.use_cases.GetPostsUseCase
import kz.singularity.domain.use_cases.GetUserByIdUseCase
import kz.singularity.domain.use_cases.GetUsersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPostsUseCase(get()) }
    factory { GetPostDetailsUseCase(get()) }
    factory { GetPostCommentsUseCase(get()) }
    factory { GetUserByIdUseCase(get()) }
    factory { GetUsersUseCase(get()) }
    factory { GetCommentsUseCase(get()) }
    factory { GetAlbumsUseCase(get()) }
    factory { GetPhotosByAlbumIdUseCase(get() ) }

}