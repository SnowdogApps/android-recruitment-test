package dog.snow.androidrecruittest.data.model.raw

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.model.type.common.Title
import dog.snow.androidrecruittest.utils.Converters
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class RawAlbum(
    @Id
    @JsonProperty("unknown")        // For some reason @JsonIgnore does not work
    var id: Long = 0,
    @Unique
    @JsonProperty("id")
    @Convert(converter = Converters.UID::class, dbType = Long::class)
    val uId: UId,
    @JsonProperty("userId")
    @Convert(converter = Converters.UID::class, dbType = Long::class)
    val userUId: UId,
    @JsonProperty("title")
    @Convert(converter = Converters.TITLE::class, dbType = String::class)
    val title: Title
) : Parcelable
