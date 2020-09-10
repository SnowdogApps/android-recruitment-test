package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.model.photo.PhotoLimit
import dog.snow.androidrecruittest.data.model.photo.RawPhoto
import dog.snow.androidrecruittest.data.source.remote.Resource
import dog.snow.androidrecruittest.data.source.remote.service.PhotoService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteSource @Inject constructor(
    private val photoService: PhotoService
) : RemoteRepository {
    override fun fetchPhotos(): Observable<Resource<List<RawPhoto>>> = photoService
        .fetchPhotos(PhotoLimit(PHOTO_LIMIT))
        .subscribeOn(Schedulers.io())
        .switchMap { Observable.just(Resource.create(it)) }
        .observeOn(AndroidSchedulers.mainThread())

    companion object {
        private const val PHOTO_LIMIT = 100
    }
}