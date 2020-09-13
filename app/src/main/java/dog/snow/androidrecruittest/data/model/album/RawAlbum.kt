package dog.snow.androidrecruittest.data.model.album

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.common.UId
import dog.snow.androidrecruittest.data.model.common.Title
import dog.snow.androidrecruittest.utils.Converters
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawAlbum(
    @Id
    @JsonProperty("unknown")        // For some reason @JsonIgnore does not work
    var id: Long = 0,
    @Unique
    @JsonProperty("id")
    @Convert(converter = Converters.UID::class, dbType = Int::class)
    val UId: UId,
    @JsonProperty("userId")
    @Convert(converter = Converters.UID::class, dbType = Int::class)
    val userUId: UId,
    @JsonProperty("title")
    @Convert(converter = Converters.TITLE::class, dbType = String::class)
    val title: Title
) : Parcelable
