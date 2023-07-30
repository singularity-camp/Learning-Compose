package kz.singularity.data.repository


import kz.singularity.data.db.room.dao.CommentDao
import kz.singularity.data.network.api.PlaceholderService
import kz.singularity.data.network.mapper.CommentMapper
import kz.singularity.domain.models.Comment
import kz.singularity.domain.repository.CommentRepository

class CommentRepositoryImpl(
    private val placeholderService: PlaceholderService,
    private val commentMapper: CommentMapper,
    private val commentDao: CommentDao
) : CommentRepository {

    val commentCache = mutableListOf<Comment>()

    override suspend fun getComments(): List<Comment> {

        if (commentCache.isNotEmpty()) {
            return commentCache
        }

        val commentEntities = commentDao.getAllComments()

        if (commentEntities.isNotEmpty()) {
            val comments = commentEntities.map { commentEntity ->
                commentMapper.fromEntityToDomain(commentEntity)
            }
            commentCache.addAll(comments)
            return comments
        }

        val remoteComments = placeholderService.getComments()
        val comments =
            remoteComments.map { commentResponse -> commentMapper.fromRemoteToDomain(commentResponse) }
        commentCache.addAll(comments)

        val commentEntitiesToStore = comments.map { comment -> commentMapper.fromDomainToEntity(comment) }
        commentDao.addComments(commentEntitiesToStore)
        return comments

    }

    override suspend fun getCommentsFromPost(postId: Long): List<Comment> {
        if (commentCache.isNotEmpty()) {
            return commentCache
        }
        val commentEntities = commentDao.getCommentsFromPost(postId)
        if(commentEntities.isNotEmpty()){
            val comments = commentEntities.map {
                commentMapper.fromEntityToDomain(it)
            }
            commentCache.addAll(comments)
            return comments
        }

        val remoteComments = placeholderService.getCommentsFromPost(postId)
        val comments = remoteComments.map { commentMapper.fromRemoteToDomain(it) }
        commentCache.addAll(comments)

        val commentEntitiesToStore = comments.map { commentMapper.fromDomainToEntity(it) }
        commentDao.addComments(commentEntitiesToStore)
        return comments
    }


}