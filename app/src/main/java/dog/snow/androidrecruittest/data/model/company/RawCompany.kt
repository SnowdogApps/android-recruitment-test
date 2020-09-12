package dog.snow.androidrecruittest.data.model.company

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.common.Name
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawCompany(
    @JsonProperty("name")           val name: Name,
    @JsonProperty("catchPhrase")    val catchPhrase: CatchPhrase,
    @JsonProperty("bs")             val bs: Bs
) : Parcelable