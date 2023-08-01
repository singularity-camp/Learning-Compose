package kz.singularity.learningcompose.ui.users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import kz.singularity.learningcompose.ui.views.UserCard
import org.koin.androidx.compose.get
import org.koin.androidx.compose.getViewModel

@Composable
fun UsersPage(
    paddingValues: PaddingValues,
    onClick: (Long) -> Unit
) {
    val viewModel: UsersViewModel = getViewModel()

    val users = viewModel.screenState.value
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.users),
            style = CustomTheme.typography.h1,
            color = CustomTheme.colors.text01
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(users.size) {
                val user = users[it]
                UserCard(
                    username = user.username,
                    fullName = user.name,
                    email = user.email,
                    onEmailClick = {
                        context.sendMail(user.email)
                    },
                    onClick = {
                        onClick(user.id)
                    }
                )
            }
        }
    }

}