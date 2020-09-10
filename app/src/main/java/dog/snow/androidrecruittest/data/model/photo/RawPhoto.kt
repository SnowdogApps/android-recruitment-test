package dog.snow.androidrecruittest.data.model.photo

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.common.Id
import dog.snow.androidrecruittest.data.model.album.Title
import dog.snow.androidrecruittest.data.model.photo.Url
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawPhoto(
    val id: Id,
    val albumId: Id,
    val title: Title,
    val url: Url,
    val thumbnailUrl: Url
) : Parcelable