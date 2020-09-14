package dog.snow.androidrecruittest.data.model.raw

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.raw.RawAddress
import dog.snow.androidrecruittest.data.model.raw.RawCompany
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.model.type.common.Name
import dog.snow.androidrecruittest.data.model.type.user.Email
import dog.snow.androidrecruittest.data.model.type.user.Phone
import dog.snow.androidrecruittest.data.model.type.user.Username
import dog.snow.androidrecruittest.data.model.type.user.Website
import dog.snow.androidrecruittest.utils.Converters
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique

import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class RawUser(
    @Id
    @JsonProperty("unknown")        // For some reason @JsonIgnore does not work
    var id: Long = 0,
    @Unique
    @JsonProperty("id")
    @Convert(converter = Converters.UID::class, dbType = Int::class)
    val uId: UId,
    @JsonProperty("name")
    @Convert(converter = Converters.NAME::class, dbType = String::class)
    val name: Name,
    @JsonProperty("username")
    @Convert(converter = Converters.USERNAME::class, dbType = String::class)
    val username: Username,
    @JsonProperty("email")
    @Convert(converter = Converters.EMAIL::class, dbType = String::class)
    val email: Email,
    @JsonProperty("address")
    @Convert(converter = Converters.ADDRESS::class, dbType = String::class)
    val address: RawAddress,
    @JsonProperty("phone")
    @Convert(converter = Converters.PHONE::class, dbType = String::class)
    val phone: Phone,
    @JsonProperty("website")
    @Convert(converter = Converters.WEBSITE::class, dbType = String::class)
    val website: Website,
    @JsonProperty("company")
    @Convert(converter = Converters.COMPANY::class, dbType = String::class)
    val company: RawCompany
) : Parcelable