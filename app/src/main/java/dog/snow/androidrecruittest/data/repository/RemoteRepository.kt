package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.model.album.RawAlbum
import dog.snow.androidrecruittest.data.model.common.Id
import dog.snow.androidrecruittest.data.model.photo.RawPhoto
import dog.snow.androidrecruittest.data.model.user.RawUser
import dog.snow.androidrecruittest.data.source.remote.Resource
import io.reactivex.Observable

interface RemoteRepository {
    fun fetchPhotos(): Observable<Resource<List<RawPhoto>>>
    fun fetchAlbum(id: Id): Observable<Resource<RawAlbum>>
    fun fetchUser(id: Id): Observable<Resource<RawUser>>
}