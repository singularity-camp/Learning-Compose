package kz.singularity.data.di

import kz.singularity.data.network.mapper.AddressMapper
import kz.singularity.data.network.mapper.AlbumMapper
import kz.singularity.data.network.mapper.CommentMapper
import kz.singularity.data.network.mapper.CompanyMapper
import kz.singularity.data.network.mapper.GeoMapper
import kz.singularity.data.network.mapper.PhotoMapper
import kz.singularity.data.network.mapper.PostsMapper
import kz.singularity.data.network.mapper.UserMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { PostsMapper() }
    factory { GeoMapper() }
    factory { CompanyMapper() }
    factory { AddressMapper(get()) }
    factory { UserMapper(get(), get()) }
    factory { CommentMapper() }
    factory { PhotoMapper() }
    factory { AlbumMapper() }
}