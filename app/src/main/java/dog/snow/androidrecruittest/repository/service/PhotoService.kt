package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.RawPhoto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {

    @GET("photos")
    fun getPhotos(
        @Query("_limit") limit: Int
    ): Single<ArrayList<RawPhoto>>
}