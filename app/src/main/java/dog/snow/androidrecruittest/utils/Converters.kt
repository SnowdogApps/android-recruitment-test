package dog.snow.androidrecruittest.utils

import com.fasterxml.jackson.databind.ObjectMapper
import dog.snow.androidrecruittest.data.model.address.*
import dog.snow.androidrecruittest.data.model.common.Name
import dog.snow.androidrecruittest.data.model.common.Title
import dog.snow.androidrecruittest.data.model.common.UId
import dog.snow.androidrecruittest.data.model.company.Bs
import dog.snow.androidrecruittest.data.model.company.CatchPhrase
import dog.snow.androidrecruittest.data.model.company.RawCompany
import dog.snow.androidrecruittest.data.model.geolocation.Coordinate
import dog.snow.androidrecruittest.data.model.photo.Url
import dog.snow.androidrecruittest.data.model.user.Email
import dog.snow.androidrecruittest.data.model.user.Phone
import dog.snow.androidrecruittest.data.model.user.Username
import dog.snow.androidrecruittest.data.model.user.Website
import io.objectbox.converter.PropertyConverter

object Converters {
    private const val NO_STRING = ""
    private const val NO_INT = 0
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

    class UID : PropertyConverter<UId, Int> {
        override fun convertToDatabaseValue(entityProperty: UId?): Int = entityProperty?.value ?: NO_INT
        override fun convertToEntityProperty(databaseValue: Int?): UId = UId(databaseValue ?: NO_INT)
    }

    class ADDRESS : PropertyConverter<RawAddress, String> {
        override fun convertToDatabaseValue(entityProperty: RawAddress?): String = ObjectMapper().writeValueAsString(entityProperty)
        override fun convertToEntityProperty(databaseValue: String?): RawAddress = ObjectMapper().readValue(databaseValue, RawAddress::class.java)
    }

    class COMPANY : PropertyConverter<RawCompany, String> {
        override fun convertToDatabaseValue(entityProperty: RawCompany?): String = ObjectMapper().writeValueAsString(entityProperty)
        override fun convertToEntityProperty(databaseValue: String?): RawCompany = ObjectMapper().readValue(databaseValue, RawCompany::class.java)
    }


    /*class COORD : PropertyConverter<Coordinate, String> {
        override fun convertToDatabaseValue(entityProperty: Coordinate?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Coordinate = Coordinate(databaseValue ?: NO_STRING)
    }

    class CATCHPHRASE : PropertyConverter<CatchPhrase, String> {
        override fun convertToDatabaseValue(entityProperty: CatchPhrase?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): CatchPhrase = CatchPhrase(databaseValue ?: NO_STRING)
    }

    class BS : PropertyConverter<Bs, String> {
        override fun convertToDatabaseValue(entityProperty: Bs?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Bs = Bs(databaseValue ?: NO_STRING)
    }


    class CITY : PropertyConverter<City, String> {
        override fun convertToDatabaseValue(entityProperty: City?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): City = City(databaseValue ?: NO_STRING)
    }

    class STREET : PropertyConverter<Street, String> {
        override fun convertToDatabaseValue(entityProperty: Street?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Street = Street(databaseValue ?: NO_STRING)
    }

    class SUITE : PropertyConverter<Suite, String> {
        override fun convertToDatabaseValue(entityProperty: Suite?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Suite = Suite(databaseValue ?: NO_STRING)
    }

    class ZIPCODE : PropertyConverter<ZipCode, String> {
        override fun convertToDatabaseValue(entityProperty: ZipCode?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): ZipCode = ZipCode(databaseValue ?: NO_STRING)
    }*/
}