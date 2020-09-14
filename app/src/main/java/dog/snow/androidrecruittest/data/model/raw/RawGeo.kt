package dog.snow.androidrecruittest.data.model.raw

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.type.geolocation.Coordinate
import dog.snow.androidrecruittest.utils.JsonLabels
import io.objectbox.annotation.Id
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawGeo(
    @JsonProperty(JsonLabels.LAT)
    val lat: Coordinate,
    @JsonProperty(JsonLabels.LNG)
    val lng: Coordinate
) : Parcelable