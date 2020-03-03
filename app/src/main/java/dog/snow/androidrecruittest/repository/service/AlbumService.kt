package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.RawPhoto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("photos")
    fun getPhotos(@Query("_limit") limit: Int = 100): Call<List<RawPhoto>>

}