package kz.singularity.learningcompose.ui.views

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.theme.CustomTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserInfo(
    userEmail: String,
    fullName: String,
    phoneNumber: String,
    website: String,
) {
    Card(
        backgroundColor = CustomTheme.colors.ui01,
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Email(email = userEmail)
            Spacer(modifier = Modifier.height(8.dp))

            FullNameStyle(fullName = fullName)
            Spacer(modifier = Modifier.height(8.dp))

            PhoneStyle(phone = phoneNumber)
            Spacer(modifier = Modifier.height(8.dp))

            WebsiteStyle(website = website)
        }
    }
}

@Composable
fun PhoneStyle(phone: String) {
    Row {
        Text(
            text = stringResource(id = R.string.phone) + ":",
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text02
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = phone,
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.main01
        )
    }
}

@Composable
fun WebsiteStyle(website: String) {
    Row {
        Text(
            text = stringResource(id = R.string.website) + ":",
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text02
        )
        Spacer(modifier = Modifier.size(8.dp))
        val context = LocalContext.current
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(
                    context,
                    "Website opened successfully",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    context,
                    "Failed to open the website or user canceled",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        Text(
            text = website,
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.links,
            modifier = Modifier.clickable {
                val fullWebsiteUrl =
                    if (website.startsWith("http://") || website.startsWith("https://")) {
                        website
                    } else {
                        "http://$website"
                    }
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(fullWebsiteUrl))
                try {
                    launcher.launch(intent)
                } catch (e: ActivityNotFoundException) {
                    // Handle if there's no web browser app installed
                    Toast.makeText(
                        context,
                        "No web browser app found.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )
    }
}
