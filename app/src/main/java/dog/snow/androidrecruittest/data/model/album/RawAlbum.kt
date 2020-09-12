package dog.snow.androidrecruittest.data.model.album

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.common.Id
import dog.snow.androidrecruittest.data.model.common.Title
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawAlbum(
    @JsonProperty("id")     val id: Id,
    @JsonProperty("userId") val userId: Id,
    @JsonProperty("title")  val title: Title
) : Parcelable
