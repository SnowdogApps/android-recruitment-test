package dog.snow.androidrecruittest.data.model.company

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.common.Name
import dog.snow.androidrecruittest.utils.Converters
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Id
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawCompany(
    @Id
    @JsonProperty("unknown")        // For some reason @JsonIgnore does not work
    var id: Long = 0,
    @JsonProperty("name")
    @Convert(converter = Converters.NAME::class, dbType = String::class)
    val name: Name,
    @JsonProperty("catchPhrase")
    @Convert(converter = Converters.CATCHPHRASE::class, dbType = String::class)
    val catchPhrase: CatchPhrase,
    @JsonProperty("bs")
    @Convert(converter = Converters.BS::class, dbType = String::class)
    val bs: Bs
) : Parcelable