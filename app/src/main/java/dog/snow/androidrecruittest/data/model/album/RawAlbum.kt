package dog.snow.androidrecruittest.data.model.album

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.common.UId
import dog.snow.androidrecruittest.data.model.common.Title
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawAlbum(
    @JsonProperty("id")     val UId: UId,
    @JsonProperty("userId") val userUId: UId,
    @JsonProperty("title")  val title: Title
) : Parcelable
