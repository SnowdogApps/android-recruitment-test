package dog.snow.androidrecruittest.data.source.remote.service

import dog.snow.androidrecruittest.data.model.album.RawAlbum
import dog.snow.androidrecruittest.data.model.common.Id
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {

    @GET("/albums/{id}")
    fun fetchAlbum(@Path("id") albumId: Id): Observable<RawAlbum>
}