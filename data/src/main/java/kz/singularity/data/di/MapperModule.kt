package kz.singularity.learningcompose.di

import org.koin.dsl.module

val mapperModule = module {
    factory { kz.singularity.data.network.mapper.PostsMapper() }
}