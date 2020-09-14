package dog.snow.androidrecruittest.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import dog.snow.androidrecruittest.data.model.raw.RawAddress
import dog.snow.androidrecruittest.data.model.raw.RawCompany

object Serializers {
    class RawAddressSerializer : JsonSerializer<RawAddress>() {

        override fun handledType(): Class<RawAddress> = RawAddress::class.java

        override fun serialize(
            value: RawAddress?,
            gen: JsonGenerator?,
            serializers: SerializerProvider?
        ) {
           gen?.apply {
               writeStartObject()
                   writeStringField(JsonLabels.STREET, value?.street?.value)
                   writeStringField(JsonLabels.SUITE, value?.suite?.value)
                   writeStringField(JsonLabels.CITY, value?.city?.value)
                   writeStringField(JsonLabels.ZIPCODE, value?.zipCode?.value)
                    writeObjectFieldStart(JsonLabels.GEO)
                        writeStringField(JsonLabels.LAT, value?.geo?.lat?.value)
                        writeStringField(JsonLabels.LNG, value?.geo?.lng?.value)
                    writeEndObject()
               writeEndObject()
           }
        }
    }

    class RawCompanySerializer : JsonSerializer<RawCompany>() {

        override fun handledType(): Class<RawCompany> = RawCompany::class.java

        override fun serialize(
            value: RawCompany?,
            gen: JsonGenerator?,
            serializers: SerializerProvider?
        ) {
            gen?.apply {
                writeStartObject()
                    writeStringField(JsonLabels.NAME, value?.name?.value)
                    writeStringField(JsonLabels.CATCHPHRASE, value?.catchPhrase?.value)
                    writeStringField(JsonLabels.BS, value?.bs?.value)
                writeEndObject()
            }
        }

    }
}