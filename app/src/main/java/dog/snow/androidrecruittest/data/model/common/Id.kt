package dog.snow.androidrecruittest.data.model.common

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Id(val value: Int) : Parcelable {
    override fun toString() = value.toString()
}