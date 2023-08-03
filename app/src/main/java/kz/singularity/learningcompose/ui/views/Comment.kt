package kz.singularity.learningcompose.ui.views

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kotlin.coroutines.CoroutineContext

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostComment(
    commentTitle: String,
    userEmail: String,
    commentBody: String,
) {
    Card(
        backgroundColor = CustomTheme.colors.ui01,
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = commentTitle,
                style = MaterialTheme.typography.h2,
                color = CustomTheme.colors.text01
            )
            Spacer(modifier = Modifier.size(8.dp))
            Email(email = userEmail)
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = commentBody,
                style = MaterialTheme.typography.body1,
                color = CustomTheme.colors.text01,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun Email(email: String) {

    val context = LocalContext.current
    val emailLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // Email sent successfully
            Log.d("Email", "Email sent successfully")
        } else {
            // Email sending failed or user canceled
            Log.d("Email", "Email sending failed or user canceled")
        }
    }

    Row {
        Text(
            text = stringResource(id = R.string.email) + ":",
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text02
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = email,
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.links,
            modifier = Modifier.clickable {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:$email")
                    putExtra(Intent.EXTRA_SUBJECT, "Subject of your message")
                    putExtra(Intent.EXTRA_TEXT, "Body of your message")
                }
                try {
                    emailLauncher.launch(emailIntent)
                } catch (e: ActivityNotFoundException) {
                    // Handle if there's no email app installed
                    Toast.makeText(
                        context,
                        "No email app found.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )
    }
}


