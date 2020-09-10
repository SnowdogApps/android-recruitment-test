package dog.snow.androidrecruittest.data.model

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.util.Id
import dog.snow.androidrecruittest.data.model.util.Title
import dog.snow.androidrecruittest.data.model.util.Url
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawPhoto(
    val id: Id,
    val albumId: Id,
    val title: Title,
    val url: Url,
    val thumbnailUrl: Url
) : Parcelable