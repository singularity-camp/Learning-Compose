package kz.singularity.learningcompose.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kz.singularity.domain.models.User
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.extensions.sendMail
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.user_profile.UserProfileScreenState
import kz.singularity.learningcompose.ui.user_profile.UserProfileViewModel
import kz.singularity.learningcompose.ui.views.AddressCard
import kz.singularity.learningcompose.ui.views.CompanyCard
import kz.singularity.learningcompose.ui.views.UserInfoCard
import org.koin.androidx.compose.getViewModel

@Composable
fun ProfilePage(
    paddingValues: PaddingValues,
    onMapClick: () -> Unit,
    onTodoClick: (Long) -> Unit
) {
    val viewModel: ProfileViewModel = getViewModel()

    when (val curState = viewModel.screenState.value) {

        ProfileScreenState.Error -> {}
        ProfileScreenState.Initial -> {}
        ProfileScreenState.Loading -> {}
        is ProfileScreenState.Profile -> {
            ProfileContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(top = 32.dp, start = 16.dp, end = 16.dp),
                user = curState.user,
                onMapClick = onMapClick,
                onTodoClick = onTodoClick
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ProfileContent(
    modifier: Modifier = Modifier,
    user: User,
    onMapClick: () -> Unit,
    onTodoClick: (Long) -> Unit
) {
    val context = LocalContext.current
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = user.username,
            style = CustomTheme.typography.h1,
            color = CustomTheme.colors.text01,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))
        UserInfoCard(
            email = user.email,
            fullName = user.name,
            phone = user.phone,
            website = user.website,
            onEmailClick = { context.sendMail(user.email) },
            onWebsiteClick = {}
        )
        Spacer(modifier = Modifier.height(24.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onTodoClick(user.id) },
            elevation = 4.dp,
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                text = stringResource(id = R.string.my_todos),
                style = CustomTheme.typography.h1,
                color = CustomTheme.colors.main01,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.company),
            style = CustomTheme.typography.h2,
            color = CustomTheme.colors.text01
        )
        Spacer(modifier = Modifier.height(16.dp))
        CompanyCard(
            companyName = user.company.name,
            fullName = user.name,
            businessService = user.company.bs
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.address),
            style = CustomTheme.typography.h2,
            color = CustomTheme.colors.text01
        )
        Spacer(modifier = Modifier.height(16.dp))
        AddressCard(
            street = user.address.street,
            suite = user.address.suite,
            city = user.address.city,
            zipCode = user.address.zipcode,
            onMapClick = onMapClick
        )
    }
}