package dog.snow.androidrecruittest.data.model.geolocation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawGeo(val lat: Coordinate, val lng: Coordinate) : Parcelable