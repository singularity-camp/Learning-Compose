package kz.singularity.data.network.mapper

import kz.singularity.data.network.response.CommentResponse
import kz.singularity.domain.models.Comment

internal class CommentMapper {

    fun fromRemoteToDomain(commentResponse: CommentResponse): Comment {
        return Comment(
            body = commentResponse.body,
            email = commentResponse.email,
            id = commentResponse.id,
            name = commentResponse.name,
            postId = commentResponse.postId
        )

    }
}