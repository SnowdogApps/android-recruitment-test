package dog.snow.androidrecruittest.data.model.address

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.geolocation.RawGeo
import dog.snow.androidrecruittest.utils.Converters
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawAddress(
    @Id
    @JsonProperty("unknown")        // For some reason @JsonIgnore does not work
    var id: Long = 0,
    @JsonProperty("street")
    @Convert(converter = Converters.STREET::class, dbType = String::class)
    val street: Street,
    @JsonProperty("suite")
    @Convert(converter = Converters.SUITE::class, dbType = String::class)
    val suite: Suite,
    @JsonProperty("city")
    @Convert(converter = Converters.CITY::class, dbType = String::class)
    val city: City,
    @JsonProperty("zipcode")
    @Convert(converter = Converters.ZIPCODE::class, dbType = String::class)
    val zipCode: ZipCode,
    @JsonProperty("geo")
    val geo: ToOne<RawGeo>
) : Parcelable