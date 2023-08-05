import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.navigation.Destinations
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.user_profile.ProfileViewModel
import kz.singularity.learningcompose.ui.views.AddressCard
import kz.singularity.learningcompose.ui.views.CompanyCard
import kz.singularity.learningcompose.ui.views.UserInfoCard
import org.koin.androidx.compose.get

@Composable
fun CurrentProfilePage(
    userId: Long,
    navController: NavController,
    viewModel: ProfileViewModel = get()
) {
    val user = viewModel.userIdToUserMap[userId]
    if (user != null) {
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
        ) {
            item {
                Text(
                    text = user.username,
                    style = MaterialTheme.typography.h1,
                    color = CustomTheme.colors.text01,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(24.dp))
                UserInfoCard(
                    userEmail = user.email,
                    fullName = user.name,
                    phoneNumber = user.phone,
                    website = user.website
                )

                Spacer(modifier = Modifier.size(24.dp))

                ButtonToDo(onClick = {
                    navController
                        .navigate(Destinations.UserTodos.createRoute(userId))

                })

                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    text = "Company",
                    style = MaterialTheme.typography.h2,
                    color = CustomTheme.colors.text01,
                )
                Spacer(modifier = Modifier.size(16.dp))
                val company = user.company
                CompanyCard(
                    companyName = company.name,
                    fullName = company.catchPhrase,
                    service = company.bs
                )

                Spacer(modifier = Modifier.size(24.dp))
                Text(
                    text = "Address",
                    style = MaterialTheme.typography.h2,
                    color = CustomTheme.colors.text01,
                )
                Spacer(modifier = Modifier.size(16.dp))
                val address = user.address
                AddressCard(
                    street = address.street,
                    suite = address.suite,
                    City = address.city,
                    Zipcode = address.zipcode
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ButtonToDo(onClick: () -> Unit) {
    Card(
        backgroundColor = CustomTheme.colors.ui01,
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        onClick = onClick,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            ToDoStyle()
        }
    }
}

@Composable
fun ToDoStyle() {
    Text(
        text = stringResource(id = R.string.todo),
        style = MaterialTheme.typography.h1,
        color = CustomTheme.colors.main01,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}
