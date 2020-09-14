package dog.snow.androidrecruittest.data.model.raw

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.type.common.Name
import dog.snow.androidrecruittest.data.model.type.company.Bs
import dog.snow.androidrecruittest.data.model.type.company.CatchPhrase
import dog.snow.androidrecruittest.utils.JsonLabels
import io.objectbox.annotation.Id
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawCompany(
    @JsonProperty(JsonLabels.NAME)
    val name: Name,
    @JsonProperty(JsonLabels.CATCHPHRASE)
    val catchPhrase: CatchPhrase,
    @JsonProperty(JsonLabels.BS)
    val bs: Bs
) : Parcelable