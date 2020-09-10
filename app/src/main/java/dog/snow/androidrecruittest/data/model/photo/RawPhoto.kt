package dog.snow.androidrecruittest.data.model.photo

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.common.Id
import dog.snow.androidrecruittest.data.model.common.Title
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawPhoto(
    @JsonProperty("id") val id: Id,
    @JsonProperty("albumId") val albumId: Id,
    @JsonProperty("title") val title: Title,
    @JsonProperty("url") val url: Url,
    @JsonProperty("thumbnailUrl") val thumbnailUrl: Url
) : Parcelable