package dog.snow.androidrecruittest.data.model.user

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.common.Id
import dog.snow.androidrecruittest.data.model.common.Name
import dog.snow.androidrecruittest.data.model.geolocation.Coordinate
import dog.snow.androidrecruittest.data.model.type.*
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawUser(
    val id: Id,
    val name: Name,
    val username: UserName,
    val email: Email,
    val address: RawAddress,
    val phone: Phone,
    val website: Website,
    val company: RawCompany
) : Parcelable {
    @Parcelize
    data class RawAddress(
        val street: String,
        val suite: String,
        val city: City,
        val zipcode: ZipCode,
        val geo: RawGeo
    ) : Parcelable {
        @Parcelize
        data class RawGeo(val lat: Coordinate, val lng: Coordinate) : Parcelable
    }

    @Parcelize
    data class RawCompany(
        val name: Name,
        val catchPhrase: String,
        val bs: String
    ) : Parcelable
}