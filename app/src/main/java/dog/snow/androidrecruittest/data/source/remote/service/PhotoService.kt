package dog.snow.androidrecruittest.data.source.remote.service

import dog.snow.androidrecruittest.data.model.raw.RawPhoto
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query


interface PhotoService {

    @GET("/photos")
    fun fetchPhotos(@Query("_limit") photoLimit: Int) : Flowable<List<RawPhoto>>

}