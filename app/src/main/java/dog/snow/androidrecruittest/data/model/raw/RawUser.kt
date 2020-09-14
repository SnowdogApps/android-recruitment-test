package dog.snow.androidrecruittest.data.model.raw

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import dog.snow.androidrecruittest.data.model.raw.RawAddress
import dog.snow.androidrecruittest.data.model.raw.RawCompany
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.model.type.common.Name
import dog.snow.androidrecruittest.data.model.type.user.Email
import dog.snow.androidrecruittest.data.model.type.user.Phone
import dog.snow.androidrecruittest.data.model.type.user.Username
import dog.snow.androidrecruittest.data.model.type.user.Website
import dog.snow.androidrecruittest.utils.Converters
import dog.snow.androidrecruittest.utils.JsonLabels
import dog.snow.androidrecruittest.utils.Serializers
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique

import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class RawUser(
    @Id
    @JsonProperty(JsonLabels.UNKNOWN)        // For some reason @JsonIgnore does not work
    var id: Long = 0,
    @Unique
    @JsonProperty(JsonLabels.ID)
    @Convert(converter = Converters.UID::class, dbType = Long::class)
    val uId: UId,
    @JsonProperty(JsonLabels.NAME)
    @Convert(converter = Converters.NAME::class, dbType = String::class)
    val name: Name,
    @JsonProperty(JsonLabels.USERNAME)
    @Convert(converter = Converters.USERNAME::class, dbType = String::class)
    val username: Username,
    @JsonProperty(JsonLabels.EMAIL)
    @Convert(converter = Converters.EMAIL::class, dbType = String::class)
    val email: Email,
    @JsonProperty(JsonLabels.ADDRESS)
    @Convert(converter = Converters.ADDRESS::class, dbType = String::class)
    val address: RawAddress,
    @JsonProperty(JsonLabels.PHONE)
    @Convert(converter = Converters.PHONE::class, dbType = String::class)
    val phone: Phone,
    @JsonProperty(JsonLabels.WEBSITE)
    @Convert(converter = Converters.WEBSITE::class, dbType = String::class)
    val website: Website,
    @JsonProperty(JsonLabels.COMPANY)
    @Convert(converter = Converters.COMPANY::class, dbType = String::class)
    val company: RawCompany
) : Parcelable