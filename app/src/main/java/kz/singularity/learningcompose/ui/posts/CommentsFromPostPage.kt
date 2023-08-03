package kz.singularity.learningcompose.ui.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kz.singularity.domain.models.Comment
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.posts.Comments
import kz.singularity.learningcompose.ui.theme.CustomTheme

@Composable
fun CommentsFromPostPage(comments: List<Comment>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item() {
            Text(
                text = stringResource(id = R.string.comments),
                style = MaterialTheme.typography.h1,
                color = CustomTheme.colors.text01
            )
            Spacer(modifier= Modifier.size(16.dp))
        }
        items(comments.size) {
            val comment = comments[it]
            Comments(comment)
        }
    }
}