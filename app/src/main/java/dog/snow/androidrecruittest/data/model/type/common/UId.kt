package dog.snow.androidrecruittest.data.model.type.common

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UId(val value: Long) : Parcelable {
    override fun toString() = value.toString()
}