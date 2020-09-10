package dog.snow.androidrecruittest.data.model.company

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.common.Name
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawCompany(
    val name: Name,
    val catchPhrase: CatchPhrase,
    val bs: Bs
) : Parcelable