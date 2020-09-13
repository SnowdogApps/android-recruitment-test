package dog.snow.androidrecruittest.data.model.geolocation

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.utils.Converters
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Id
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawGeo(
    @Id
    @JsonProperty("unknown")        // For some reason @JsonIgnore does not work
    var id: Long = 0,
    @JsonProperty("lat")
    @Convert(converter = Converters.COORD::class, dbType = String::class)
    val lat: Coordinate,
    @JsonProperty("lng")
    @Convert(converter = Converters.COORD::class, dbType = String::class)
    val lng: Coordinate) : Parcelable