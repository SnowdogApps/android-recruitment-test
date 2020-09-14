package dog.snow.androidrecruittest

import dog.snow.androidrecruittest.data.model.raw.*
import dog.snow.androidrecruittest.data.model.type.address.City
import dog.snow.androidrecruittest.data.model.type.address.Street
import dog.snow.androidrecruittest.data.model.type.address.Suite
import dog.snow.androidrecruittest.data.model.type.address.ZipCode
import dog.snow.androidrecruittest.data.model.type.common.Name
import dog.snow.androidrecruittest.data.model.type.common.Title
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.model.type.company.Bs
import dog.snow.androidrecruittest.data.model.type.company.CatchPhrase
import dog.snow.androidrecruittest.data.model.type.geolocation.Coordinate
import dog.snow.androidrecruittest.data.model.type.photo.Url
import dog.snow.androidrecruittest.data.model.type.user.Email
import dog.snow.androidrecruittest.data.model.type.user.Phone
import dog.snow.androidrecruittest.data.model.type.user.Username
import dog.snow.androidrecruittest.data.model.type.user.Website

object TestingUtils {
    val rawPhoto = RawPhoto(
        0,
        UId(0),
        UId(0),
        Title(""),
        Url(""),
        Url("")
    )

    val rawUser = RawUser(
        0,
        UId(0),
        Name(""),
        Username(""),
        Email(""),
        RawAddress(
            Street(""),
            Suite(""),
            City(""),
            ZipCode(""),
            RawGeo(Coordinate(""), Coordinate(""))
        ),
        Phone(""),
        Website(""),
        RawCompany(
            Name(""),
            CatchPhrase(""),
            Bs("")
        )
    )
}