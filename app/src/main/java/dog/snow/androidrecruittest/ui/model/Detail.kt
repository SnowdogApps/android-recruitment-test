package dog.snow.androidrecruittest.ui.model

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.common.Id
import dog.snow.androidrecruittest.data.model.common.Title
import dog.snow.androidrecruittest.data.model.photo.Url
import dog.snow.androidrecruittest.data.model.user.Email
import dog.snow.androidrecruittest.data.model.user.Phone
import dog.snow.androidrecruittest.data.model.user.Username
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Detail(
    val photoId: Id,
    val photoTitle: Title,
    val albumTitle: Title,
    val username: Username,
    val email: Email,
    val phone: Phone,
    val url: Url
) : Parcelable