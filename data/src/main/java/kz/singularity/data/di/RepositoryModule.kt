package kz.singularity.data.di

import kz.singularity.data.repository.AlbumRepositoryImpl
import kz.singularity.data.repository.CommentRepositoryImpl
import kz.singularity.data.repository.PostRepositoryImpl
import kz.singularity.data.repository.UserRepositoryImpl
import kz.singularity.domain.repository.AlbumRepository
import kz.singularity.domain.repository.CommentRepository
import kz.singularity.domain.repository.PostRepository
import kz.singularity.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<PostRepository> { PostRepositoryImpl(get(), get(), get()) }
    factory<UserRepository> { UserRepositoryImpl(get(), get(), get()) }
    factory<CommentRepository> { CommentRepositoryImpl(get(), get()) }
    factory<AlbumRepository> { AlbumRepositoryImpl(get(), get(), get()) }
}