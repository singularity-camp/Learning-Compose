package kz.singularity.learningcompose.models

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlbumUI(
    val id:Long,
    val imgUrl: String,
    val name: String,
    val userName: String
):Parcelable{
    companion object CustomNavType {
        val NavigationType: NavType<AlbumUI> = object : NavType<AlbumUI>(false) {
            override fun get(bundle: Bundle, key: String): AlbumUI? {
                return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    bundle.getParcelable(key, AlbumUI::class.java)
                } else {
                    bundle.getParcelable(key)
                }
            }

            override fun parseValue(value: String): AlbumUI {
                return Gson().fromJson(value, AlbumUI::class.java)
            }

            override fun put(bundle: Bundle, key: String, value: AlbumUI) {
                bundle.putParcelable(key, value)
            }
        }
    }
}
