package dog.snow.androidrecruittest.data.model.address

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.geolocation.RawGeo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawAddress(
    @JsonProperty("street")     val street: Street,
    @JsonProperty("suite")      val suite: Suite,
    @JsonProperty("city")       val city: City,
    @JsonProperty("zipCode")    val zipCode: ZipCode,
    @JsonProperty("geo")        val geo: RawGeo
) : Parcelable