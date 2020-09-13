package dog.snow.androidrecruittest.data.model.user

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.address.RawAddress
import dog.snow.androidrecruittest.data.model.common.UId
import dog.snow.androidrecruittest.data.model.common.Name
import dog.snow.androidrecruittest.data.model.company.RawCompany

import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawUser(
    @JsonProperty("id")         val UId: UId,
    @JsonProperty("name")       val name: Name,
    @JsonProperty("username")   val username: Username,
    @JsonProperty("email")      val email: Email,
    @JsonProperty("address")    val address: RawAddress,
    @JsonProperty("phone")      val phone: Phone,
    @JsonProperty("website")    val website: Website,
    @JsonProperty("company")    val company: RawCompany
) : Parcelable