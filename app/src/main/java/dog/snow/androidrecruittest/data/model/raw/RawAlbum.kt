package dog.snow.androidrecruittest.data.model.raw

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.model.type.common.Title
import dog.snow.androidrecruittest.utils.Converters
import dog.snow.androidrecruittest.utils.JsonLabels
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class RawAlbum(
    @Id
    @JsonProperty(JsonLabels.UNKNOWN)        // For some reason @JsonIgnore does not work
    var id: Long = 0,
    @Unique
    @JsonProperty(JsonLabels.ID)
    @Convert(converter = Converters.UID::class, dbType = Long::class)
    val uId: UId,
    @JsonProperty(JsonLabels.USERID)
    @Convert(converter = Converters.UID::class, dbType = Long::class)
    val userUId: UId,
    @JsonProperty(JsonLabels.TITLE)
    @Convert(converter = Converters.TITLE::class, dbType = String::class)
    val title: Title
) : Parcelable
