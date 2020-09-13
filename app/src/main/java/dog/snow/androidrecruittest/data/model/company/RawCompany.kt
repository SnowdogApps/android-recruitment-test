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
    val name: Name,
    @JsonProperty("catchPhrase")
    val catchPhrase: CatchPhrase,
    @JsonProperty("bs")
    val bs: Bs
) : Parcelable