package kz.singularity.learningcompose.di

import kz.singularity.data.repository.CommentRepositoryImpl
import kz.singularity.data.repository.PostRepositoryImpl
import kz.singularity.data.repository.UserRepositoryImpl
import kz.singularity.domain.repository.CommentRepository
import kz.singularity.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory <kz.singularity.domain.repository.PostRepository> {
        PostRepositoryImpl(
            get(),
            get(),
            get(),
        )
    }

    factory< CommentRepository > { CommentRepositoryImpl(get(), get(), get()) }
    factory<UserRepository> { UserRepositoryImpl(get(), get(), get()) }
}