package kz.singularity.learningcompose.di

import kz.singularity.data.repository.PostRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory <kz.singularity.domain.repository.PostRepository> {
        PostRepositoryImpl(
            get(),
            get(),
            get(),
        )
    }
}