package kz.singularity.learningcompose.ui.main

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kz.singularity.learningcompose.ui.posts.PostsPage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PostsPage()
            }
        }
    }
}



@Composable
fun MainScreen(
    text: String, onTextChange: (String) -> Unit
) {
    TextField(
        value = text, onValueChange = onTextChange, modifier = Modifier.fillMaxWidth()
    )
}

fun Activity.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}


