package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.model.photo.RawPhoto
import dog.snow.androidrecruittest.data.source.remote.Resource
import io.reactivex.Observable

interface RemoteRepository {
    fun fetchPhotos(): Observable<Resource<List<RawPhoto>>>
}