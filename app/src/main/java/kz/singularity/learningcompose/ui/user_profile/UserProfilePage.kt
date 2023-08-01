package kz.singularity.learningcompose.ui.user_profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import kz.singularity.learningcompose.ui.views.AddressCard
import kz.singularity.learningcompose.ui.views.CompanyCard
import kz.singularity.learningcompose.ui.views.UserInfoCard
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun UserProfilePage(
    userId: Long,
    paddingValues: PaddingValues,
    onMapClick: () -> Unit
) {
    val viewModel: UserProfileViewModel = getViewModel { parametersOf(userId) }

    when (val curState = viewModel.screenState.value) {
        UserProfileScreenState.Error -> {}
        UserProfileScreenState.Initial -> {}
        UserProfileScreenState.Loading -> {}
        is UserProfileScreenState.Profile -> {
            ProfileContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(top = 32.dp, start = 16.dp, end = 16.dp),
                user = curState.user,
                onMapClick = onMapClick,
            )
        }
    }

}

@Composable
private fun ProfileContent(
    modifier: Modifier = Modifier,
    user: User,
    onMapClick: () -> Unit,
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