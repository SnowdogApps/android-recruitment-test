package dog.snow.androidrecruittest.data.model.raw

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.type.common.Title
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.model.type.photo.Url
import dog.snow.androidrecruittest.utils.Converters
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique


import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class RawPhoto(
    @Id
    @JsonProperty("unknown")        // For some reason @JsonIgnore does not work
    var id: Long = 0,
    @Unique
    @JsonProperty("id")
    @Convert(converter = Converters.UID::class, dbType = Int::class)
    val uId: UId,
    @JsonProperty("albumId")
    @Convert(converter = Converters.UID::class, dbType = Int::class)
    val albumUId: dog.snow.androidrecruittest.data.model.type.common.UId,
    @JsonProperty("title")
    @Convert(converter = Converters.TITLE::class, dbType = String::class)
    val title: Title,
    @JsonProperty("url")
    @Convert(converter = Converters.URL::class, dbType = String::class)
    val url: Url,
    @JsonProperty("thumbnailUrl")
    @Convert(converter = Converters.URL::class, dbType = String::class)
    val thumbnailUrl: Url
) : Parcelable


/*
@Entity
@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)
data class RawPhoto(
    @Id
    @JsonProperty("unknown")        // For some reason @JsonIgnore does not work
    var id: Long = 0,
    @Unique
    @JsonProperty("id")
    @Convert(converter = Converters.UID::class, dbType = Int::class)
    val uId: Id,
    @JsonProperty("albumId")
    @Convert(converter = Converters.UID::class, dbType = Int::class)
    val albumUUId: dog.snow.androidrecruittest.data.model.type.common.UId,
    @JsonProperty("title")
    @Convert(converter = Converters.TITLE::class, dbType = String::class)
    val title: Title,
    @JsonProperty("url")
    @Convert(converter = Converters.URL::class, dbType = String::class)
    val url: Url,
    @JsonProperty("thumbnailUrl")
    @Convert(converter = Converters.URL::class, dbType = String::class)
    val thumbnailUrl: Url
) : Parcelable*/