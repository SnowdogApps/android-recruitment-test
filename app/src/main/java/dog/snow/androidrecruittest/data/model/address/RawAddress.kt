package dog.snow.androidrecruittest.data.model.address

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.geolocation.RawGeo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawAddress(
    val street: Street,
    val suite: Suite,
    val city: City,
    val zipCode: ZipCode,
    val geo: RawGeo
) : Parcelable