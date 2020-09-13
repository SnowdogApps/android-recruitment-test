package dog.snow.androidrecruittest.data.model.user

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.address.RawAddress
import dog.snow.androidrecruittest.data.model.common.UId
import dog.snow.androidrecruittest.data.model.common.Name
import dog.snow.androidrecruittest.data.model.company.RawCompany
import dog.snow.androidrecruittest.utils.Converters
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique
import io.objectbox.relation.ToOne

import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawUser(
    @Id
    @JsonProperty("unknown")        // For some reason @JsonIgnore does not work
    var id: Long = 0,
    @Unique
    @JsonProperty("id")
    @Convert(converter = Converters.UID::class, dbType = Int::class)
    val UId: UId,
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
    val address: ToOne<RawAddress>,
    @JsonProperty("phone")
    @Convert(converter = Converters.PHONE::class, dbType = String::class)
    val phone: Phone,
    @JsonProperty("website")
    @Convert(converter = Converters.WEBSITE::class, dbType = String::class)
    val website: Website,
    @JsonProperty("company")
    val company: ToOne<RawCompany>
) : Parcelable