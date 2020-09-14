package dog.snow.androidrecruittest.data.model.raw

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.type.address.City
import dog.snow.androidrecruittest.data.model.type.address.Street
import dog.snow.androidrecruittest.data.model.type.address.Suite
import dog.snow.androidrecruittest.data.model.type.address.ZipCode
import dog.snow.androidrecruittest.utils.JsonLabels
import io.objectbox.annotation.Id
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawAddress(
    @JsonProperty(JsonLabels.STREET)
    val street: Street,
    @JsonProperty(JsonLabels.SUITE)
    val suite: Suite,
    @JsonProperty(JsonLabels.CITY)
    val city: City,
    @JsonProperty(JsonLabels.ZIPCODE)
    val zipCode: ZipCode,
    @JsonProperty(JsonLabels.GEO)
    val geo: RawGeo
) : Parcelable