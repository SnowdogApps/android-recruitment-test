package dog.snow.androidrecruittest.ui.model

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.common.Id
import dog.snow.androidrecruittest.data.model.common.Title
import dog.snow.androidrecruittest.data.model.photo.Url
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItem(
    val id: Id,
    val title: Title,
    val albumTitle: Title,
    val thumbnailUrl: Url
) : Parcelable