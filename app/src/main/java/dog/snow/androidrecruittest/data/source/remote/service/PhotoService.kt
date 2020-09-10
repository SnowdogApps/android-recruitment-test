package dog.snow.androidrecruittest.data.source.remote.service

import dog.snow.androidrecruittest.data.model.photo.PhotoLimit
import dog.snow.androidrecruittest.data.model.photo.RawPhoto
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface PhotoService {

    @GET("/photos")
    fun fetchPhotos(@Query("_limit") photoLimit: PhotoLimit) : Observable<Response<List<RawPhoto>>>

}