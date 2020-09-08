package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.RawAlbum
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {

    @GET("albums/{albumId}")
    fun getAlbum(
        @Path("albumId") albumId: Long
    ): Single<RawAlbum>
}