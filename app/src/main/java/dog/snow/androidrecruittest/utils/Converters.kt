package dog.snow.androidrecruittest.utils

import com.fasterxml.jackson.databind.ObjectMapper
import dog.snow.androidrecruittest.data.model.raw.RawAddress
import dog.snow.androidrecruittest.data.model.type.common.Name
import dog.snow.androidrecruittest.data.model.type.common.Title
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.model.raw.RawCompany
import dog.snow.androidrecruittest.data.model.type.photo.Url
import dog.snow.androidrecruittest.data.model.type.user.Email
import dog.snow.androidrecruittest.data.model.type.user.Phone
import dog.snow.androidrecruittest.data.model.type.user.Username
import dog.snow.androidrecruittest.data.model.type.user.Website
import io.objectbox.converter.PropertyConverter

object Converters {
    private const val NO_STRING = ""
    private const val NO_LONG = 0L
    class WEBSITE : PropertyConverter<Website, String> {
        override fun convertToDatabaseValue(entityProperty: Website?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Website = Website(databaseValue ?: NO_STRING)
    }

    class USERNAME : PropertyConverter<Username, String> {
        override fun convertToDatabaseValue(entityProperty: Username?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Username = Username(databaseValue ?: NO_STRING)
    }

    class PHONE : PropertyConverter<Phone, String> {
        override fun convertToDatabaseValue(entityProperty: Phone?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Phone = Phone(databaseValue ?: NO_STRING)
    }

    class EMAIL : PropertyConverter<Email, String> {
        override fun convertToDatabaseValue(entityProperty: Email?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Email = Email(databaseValue ?: NO_STRING)
    }

    class URL : PropertyConverter<Url, String> {
        override fun convertToDatabaseValue(entityProperty: Url?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Url = Url(databaseValue ?: NO_STRING)
    }


    class NAME : PropertyConverter<Name, String> {
        override fun convertToDatabaseValue(entityProperty: Name?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Name = Name(databaseValue ?: NO_STRING)
    }

    class TITLE : PropertyConverter<Title, String> {
        override fun convertToDatabaseValue(entityProperty: Title?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Title = Title(databaseValue ?: NO_STRING)
    }

    class UID : PropertyConverter<UId, Long> {
        override fun convertToDatabaseValue(entityProperty: UId?): Long = entityProperty?.value ?: NO_LONG
        override fun convertToEntityProperty(databaseValue: Long?): UId = UId(databaseValue ?: NO_LONG)
    }

    class ADDRESS : PropertyConverter<RawAddress, String> {
        override fun convertToDatabaseValue(entityProperty: RawAddress?): String = ObjectMapper().writeValueAsString(entityProperty)
        override fun convertToEntityProperty(databaseValue: String?): RawAddress = ObjectMapper().readValue(databaseValue, RawAddress::class.java)
    }

    class COMPANY : PropertyConverter<RawCompany, String> {
        override fun convertToDatabaseValue(entityProperty: RawCompany?): String = ObjectMapper().writeValueAsString(entityProperty)
        override fun convertToEntityProperty(databaseValue: String?): RawCompany = ObjectMapper().readValue(databaseValue, RawCompany::class.java)
    }
}