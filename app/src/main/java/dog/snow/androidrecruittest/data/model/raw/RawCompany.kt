package dog.snow.androidrecruittest.data.model.raw

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.type.common.Name
import dog.snow.androidrecruittest.data.model.type.company.Bs
import dog.snow.androidrecruittest.data.model.type.company.CatchPhrase
import io.objectbox.annotation.Id
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawCompany(
    @Id
    @JsonProperty("unknown")        // For some reason @JsonIgnore does not work
    var id: Long = 0,
    @JsonProperty("name")
    val name: Name,
    @JsonProperty("catchPhrase")
    val catchPhrase: CatchPhrase,
    @JsonProperty("bs")
    val bs: Bs
) : Parcelable