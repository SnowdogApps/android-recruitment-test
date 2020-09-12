package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.source.remote.Resource
import dog.snow.androidrecruittest.data.source.remote.service.AlbumService
import dog.snow.androidrecruittest.data.source.remote.service.PhotoService
import dog.snow.androidrecruittest.data.source.remote.service.UserService
import io.reactivex.Flowable
import io.reactivex.Single

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRepository_Impl @Inject constructor(
    private val photoService: PhotoService,
    private val albumService: AlbumService,
    private val userService: UserService
) : RemoteRepository {

    override fun fetchData(): Single<out Resource<Void>> = photoService.fetchPhotos(PHOTO_LIMIT)    // Fetch photos.
        .subscribeOn(Schedulers.io())
        .switchMap { response -> Flowable.fromIterable(response.distinctBy { it.albumId }) }
        .flatMap { albumService.fetchAlbum(it.albumId) }                                        // Fetch album.
        .flatMap { response -> userService.fetchUser(response.userId) }                         // Fetch user.
        .toList()                                                                               // Group results.
        .map { Resource.Success<Void>(null) }                                             // At the time whole data is stored.
        .observeOn(AndroidSchedulers.mainThread())

    companion object {
        private const val PHOTO_LIMIT = 100
    }
}