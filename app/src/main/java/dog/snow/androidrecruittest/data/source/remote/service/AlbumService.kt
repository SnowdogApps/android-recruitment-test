package dog.snow.androidrecruittest.data.source.remote.service

import dog.snow.androidrecruittest.data.model.raw.RawAlbum
import dog.snow.androidrecruittest.data.model.type.common.UId
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {

    @GET("/albums/{id}")
    fun fetchAlbum(@Path("id") albumUId: UId): Flowable<RawAlbum>
}