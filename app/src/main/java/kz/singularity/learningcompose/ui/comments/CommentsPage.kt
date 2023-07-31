package kz.singularity.learningcompose.ui.comments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.extensions.sendMail
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.views.PostCommentCard
import org.koin.androidx.compose.getViewModel

@Composable
fun CommentsPage(
    paddingValues: PaddingValues
) {
    val viewModel: CommentsViewModel = getViewModel()
    val comments = viewModel.screenState.value

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.Comments),
            style = CustomTheme.typography.h1,
            color = CustomTheme.colors.text01
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(comments.size) {
                val comment = comments[it]
                PostCommentCard(
                    commentTitle = comment.name,
                    userEmail = comment.email,
                    commentBody = comment.body,
                    onClick = { context.sendMail(comment.email) }
                )
            }
        }
    }
}