package kz.singularity.data.network.mapper

import kz.singularity.data.db.room.entity.PostEntity
import kz.singularity.data.network.response.PostResponse
import kz.singularity.domain.models.Post

internal class PostsMapper {
    fun fromRemoteToDomain(postResponse: PostResponse): Post {
        return Post(
            body = postResponse.body,
            id = postResponse.id,
            title = postResponse.title,
            userId = postResponse.userId
        )
    }

    fun fromEntityToDomain(postEntity: PostEntity): Post {
        return Post(
            body = postEntity.body,
            id = postEntity.id,
            title = postEntity.title,
            userId = postEntity.userId
        )
    }


    fun fromDomainToEntity(post: Post): PostEntity {
        return PostEntity(
            body = post.body,
            id = post.id,
            title = post.title,
            userId = post.userId
        )
    }
}