package dog.snow.androidrecruittest.data.model.album

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.common.Id
import dog.snow.androidrecruittest.data.model.photo.Title
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawAlbum(
    val id: Id,
    val userId: Id,
    val title: Title
) : Parcelable
