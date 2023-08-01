package kz.singularity.learningcompose.extensions

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast


fun Context.sendMail(to: String) {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "vnd.android.cursor.item/email" // or "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(
            this,
            "No app available to send email!!",
            Toast.LENGTH_SHORT
        ).show()
    } catch (t: Throwable) {
        t.stackTrace
    }
}