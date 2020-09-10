package dog.snow.androidrecruittest.data.model.photo

import com.fasterxml.jackson.annotation.JsonProperty

data class PhotoLimit(@JsonProperty("_limit") val value: Int)