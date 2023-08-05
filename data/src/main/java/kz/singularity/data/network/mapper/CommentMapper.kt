package kz.singularity.data.network.mapper

import com.example.dependencyinjection.data.db.room.entity.CommentEntity
import kz.singularity.data.db.room.entity.PostEntity
import kz.singularity.data.network.response.CommentResponse
import kz.singularity.data.network.response.PostResponse
import kz.singularity.domain.models.Comment
import kz.singularity.domain.models.Post

class CommentMapper {

    fun fromRemoteToDomain(commentResponse: CommentResponse): kz.singularity.domain.models.Comment {
        return kz.singularity.domain.models.Comment(
            body = commentResponse.body,
            id = commentResponse.id,
            name = commentResponse.name,
            email = commentResponse.email,
            postId = commentResponse.postId
        )
    }
    fun fromEntityToDomain(commentEntity: CommentEntity): kz.singularity.domain.models.Comment {
        return kz.singularity.domain.models.Comment(
            id = commentEntity.id,
            body = commentEntity.body,
            name = commentEntity.name,
            email = commentEntity.email,
            postId = commentEntity.postId
        )
    }
    fun fromDomainToEntity(comment: Comment): CommentEntity {
        return CommentEntity(
            id = comment.id,
            body = comment.body,
            email = comment.email,
            name = comment.name,
            postId = comment.postId
        )
    }
}