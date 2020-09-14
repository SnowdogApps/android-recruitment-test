package dog.snow.androidrecruittest.ui.model

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.model.type.common.Title
import dog.snow.androidrecruittest.data.model.type.photo.Url
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItem(
    val UId: UId,
    val title: Title,
    val albumTitle: Title,
    val thumbnailUrl: Url
) : Parcelable