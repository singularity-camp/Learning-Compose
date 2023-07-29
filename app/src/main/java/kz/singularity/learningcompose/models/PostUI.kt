package kz.singularity.learningcompose.models

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostUI(
    val body: String,
    val id: Long,
    val title: String,
    val userId: Long
) : Parcelable {
    companion object CustomNavType {
        val NavigationType: NavType<PostUI> = object : NavType<PostUI>(false) {
            override fun get(bundle: Bundle, key: String): PostUI? {
                return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    bundle.getParcelable(key, PostUI::class.java)
                } else {
                    bundle.getParcelable(key)
                }
            }

            override fun parseValue(value: String): PostUI {
                return Gson().fromJson(value, PostUI::class.java)
            }

            override fun put(bundle: Bundle, key: String, value: PostUI) {
                bundle.putParcelable(key, value)
            }
        }
    }
}