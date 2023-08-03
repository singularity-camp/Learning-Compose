package kz.singularity.learningcompose.ui.views

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kz.singularity.learningcompose.R
import kz.singularity.learningcompose.ui.theme.CustomTheme
import androidx.core.content.ContextCompat.startActivity
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import android.content.Context as AndroidContext


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddressCard(
    street: String,
    suite: String,
    City: String,
    Zipcode: String
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
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StreetStyle(s = street)
            SuiteStyle(s = suite)
            CityStyle(s = City)
            ZipcodeStyle(s = Zipcode)
            ShowOnMapButton(
                street = street,
                city = City,
                zipcode = Zipcode,
            )
        }
    }
}

@Composable
fun StreetStyle(s: String) {
    Row {
        Text(
            text = stringResource(id = R.string.street) + ":",
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text02
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = s,
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text01
        )

    }
}
@Composable
fun ShowOnMapButton(street: String, city: String, zipcode: String) {
    val context = LocalContext.current
    Button(
        onClick = {
            launchMapIntent(context, street, city, zipcode)
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.show_on_map),
            style = MaterialTheme.typography.button
        )
    }
}

private fun launchMapIntent(context: Context, street: String, city: String, zipcode: String) {
    val address = Uri.encode("$street, $city, $zipcode")
    val uri = Uri.parse("geo:0,0?q=$address")
    val mapIntent = Intent(Intent.ACTION_VIEW, uri)
    try {
        context.startActivity(mapIntent)
    } catch (e: ActivityNotFoundException) {
        // Handle if there's no map app installed
        Toast.makeText(context, "No map app found.", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun SuiteStyle(s: String) {
    Row {
        Text(
            text = stringResource(id = R.string.suite) + ":",
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text02
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = s,
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text01
        )
    }
}

@Composable
fun CityStyle(s: String) {
    Row {
        Text(
            text = stringResource(id = R.string.city) + ":",
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text02
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = s,
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text01
        )
    }
}

@Composable
fun ZipcodeStyle(s: String) {
    Row {
        Text(
            text = stringResource(id = R.string.zipcode) + ":",
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text02
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = s,
            style = MaterialTheme.typography.h4,
            color = CustomTheme.colors.text01
        )
    }
}