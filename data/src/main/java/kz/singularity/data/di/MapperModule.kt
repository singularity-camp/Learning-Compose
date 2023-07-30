package kz.singularity.learningcompose.di

import kz.singularity.data.network.mapper.AddressMapper
import kz.singularity.data.network.mapper.CommentMapper
import kz.singularity.data.network.mapper.CompanyMapper
import kz.singularity.data.network.mapper.GeoMapper
import kz.singularity.data.network.mapper.UserMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { kz.singularity.data.network.mapper.PostsMapper() }
    factory { CommentMapper() }
    factory { GeoMapper() }
    factory { CompanyMapper() }
    factory { AddressMapper(get()) }
    factory { UserMapper(get(), get()) }
}