package dog.snow.androidrecruittest.data.model

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.util.Id
import dog.snow.androidrecruittest.data.model.util.Title
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawAlbum(
    val id: Id,
    val userId: Id,
    val title: Title
) : Parcelable
