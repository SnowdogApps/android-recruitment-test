package dog.snow.androidrecruittest.data.model.geolocation

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawGeo(
    @JsonProperty("lat") val lat: Coordinate,
    @JsonProperty("lng") val lng: Coordinate) : Parcelable