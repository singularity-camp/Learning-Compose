package kz.singularity.learningcompose.ui.post_detail

import kz.singularity.domain.models.Comment

data class PostDetailState(
        val title: String,
        val body: String,
        val userName: String?,
        val comments: List<Comment>
    )