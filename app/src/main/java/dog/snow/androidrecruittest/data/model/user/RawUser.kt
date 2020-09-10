package dog.snow.androidrecruittest.data.model.user

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.address.RawAddress
import dog.snow.androidrecruittest.data.model.common.Id
import dog.snow.androidrecruittest.data.model.common.Name
import dog.snow.androidrecruittest.data.model.company.RawCompany

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
) : Parcelable