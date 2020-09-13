package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.model.photo.RawPhoto
import dog.snow.androidrecruittest.data.source.remote.Resource
import dog.snow.androidrecruittest.data.source.remote.service.AlbumService
import dog.snow.androidrecruittest.data.source.remote.service.PhotoService
import dog.snow.androidrecruittest.data.source.remote.service.UserService
import io.objectbox.Box
import io.reactivex.Flowable
import io.reactivex.Single

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SourceRepository_Impl @Inject constructor(
    private val photoService: PhotoService,
    private val albumService: AlbumService,
    private val userService: UserService,
    private val photoBox: Box<RawPhoto>
) : SourceRepository {

    override fun fetchData(): Single<out Resource<Void>> = photoService.fetchPhotos(PHOTO_LIMIT) // Fetch photos.
        .subscribeOn(Schedulers.io())
        .map { putPhotos(it) }
        .switchMap { response -> Flowable.fromIterable(response.distinctBy { it.albumUId }) }
        .flatMap { albumService.fetchAlbum(it.albumUId) }                                       // Fetch album.
        .flatMap { response -> userService.fetchUser(response.userUId) }                        // Fetch user.
        .toList()                                                                               // Group results.
        .map { Resource.Success<Void>(null) }                                             // At the time whole data is stored.
        .observeOn(AndroidSchedulers.mainThread())


    private fun putPhotos(photos: List<RawPhoto>):List<RawPhoto> =  with(photoBox) {
        removeAll()
        put(photos)
        photos
    }

    companion object {
        private const val PHOTO_LIMIT = 100
        private val TAG = SourceRepository_Impl::class.simpleName
    }
}