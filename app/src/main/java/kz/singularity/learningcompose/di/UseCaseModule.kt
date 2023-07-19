package kz.singularity.learningcompose.di

import kz.singularity.domain.use_cases.GetPostDetailsUseCase
import kz.singularity.domain.use_cases.GetPostsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { kz.singularity.domain.use_cases.GetPostsUseCase(get()) }
    factory { kz.singularity.domain.use_cases.GetPostDetailsUseCase(get()) }
}