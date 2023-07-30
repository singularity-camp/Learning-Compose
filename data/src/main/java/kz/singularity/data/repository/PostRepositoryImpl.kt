package kz.singularity.data.repository

import kz.singularity.data.db.room.dao.PostDao
import kz.singularity.data.network.api.PlaceholderService
import kz.singularity.data.network.mapper.PostsMapper
import kz.singularity.data.network.response.PostResponse
import kz.singularity.domain.models.Post
import kz.singularity.domain.models.PostDetails

internal class PostRepositoryImpl(
    private val placeholderService: PlaceholderService,
    private val postsMapper: PostsMapper,
    private val postDao: PostDao,
) : kz.singularity.domain.repository.PostRepository {

    val postsCache = mutableListOf<Post>()

    override suspend fun getPosts(): List<Post> {

        if (postsCache.isNotEmpty()) {
            return postsCache
        }

        val postEntities = postDao.getAllPosts()
        if (postEntities.isNotEmpty()) {
            val posts = postEntities.map { postEntity -> postsMapper.fromEntityToDomain(postEntity) }
            postsCache.addAll(posts)
            return posts
        }

        val remotePosts = placeholderService.getPosts()
        val posts = remotePosts.map { postResponse -> postsMapper.fromRemoteToDomain(postResponse) }
        postsCache.addAll(posts)

        val postEntitiesToStore = posts.map { post -> postsMapper.fromDomainToEntity(post) }
        postDao.addPosts(postEntitiesToStore)
        return posts
    }

    override suspend fun getPostDetails(postId: Long): kz.singularity.domain.models.Post {
        val postResponse = placeholderService.getPostDetails(postId)
        return postsMapper.fromRemoteToDomain(postResponse)
    }

 /*   override suspend fun getUserIdFromPost(postId: Long): PostDetails {
        val userId = placeholderService.getUserIdFromPost(postId)
        return postsMapper.fromRemoteToDomain(userId)
    }*/


}