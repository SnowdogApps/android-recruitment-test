package dog.snow.androidrecruittest.data.model.address

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ZipCode(val value: String) : Parcelable