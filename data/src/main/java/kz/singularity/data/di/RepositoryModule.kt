package kz.singularity.learningcompose.di

import kz.singularity.domain.repository.TodoRepository
import kz.singularity.data.repository.AlbumRepositoryImpl
import kz.singularity.data.repository.CommentRepositoryImpl
import kz.singularity.data.repository.PhotoRepositoryImpl
import kz.singularity.data.repository.PostRepositoryImpl
import kz.singularity.data.repository.TodoRepositoryImpl
import kz.singularity.data.repository.UserRepositoryImpl
import kz.singularity.domain.repository.AlbumRepository
import kz.singularity.domain.repository.CommentRepository
import kz.singularity.domain.repository.PhotoRepository
import kz.singularity.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<kz.singularity.domain.repository.PostRepository> {
        PostRepositoryImpl(
            get(),
            get(),
            get(),
        )
    }

    factory<CommentRepository> { CommentRepositoryImpl(get(), get(), get()) }
    factory<UserRepository> { UserRepositoryImpl(get(), get(), get()) }
    factory<AlbumRepository> { AlbumRepositoryImpl(get(), get(), get()) }
    factory<PhotoRepository> { PhotoRepositoryImpl(get(), get()) }
    factory<TodoRepository> { TodoRepositoryImpl(get(), get()) }
}