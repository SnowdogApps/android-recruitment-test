package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.model.album.RawAlbum
import dog.snow.androidrecruittest.data.model.photo.RawPhoto
import dog.snow.androidrecruittest.data.model.user.RawUser
import dog.snow.androidrecruittest.data.source.remote.Resource
import dog.snow.androidrecruittest.data.source.remote.service.AlbumService
import dog.snow.androidrecruittest.data.source.remote.service.PhotoService
import dog.snow.androidrecruittest.data.source.remote.service.UserService
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteSource @Inject constructor(
    private val photoService: PhotoService,
    private val albumService: AlbumService,
    private val userService: UserService
) : RemoteRepository {

    override fun fetchData(): Single<Resource<Void>> {
        val photosSource = fetchPhotos()
        val albumsSource = fetchAlbums(photosSource)
        val usersSource = fetchUsers(albumsSource)
        return Single.zip(
            photosSource.toList(),
            albumsSource.toList(),
            usersSource.toList(),
            Function3<List<RawPhoto>, List<RawAlbum>, List<RawUser>, Resource<Void>> { photos, albums, users ->
                return@Function3 Resource.Success(null)
            })            //TODO: create extention?
            .observeOn(AndroidSchedulers.mainThread())
    }

    //TODO: emit objects one by one
    private fun fetchPhotos() = photoService.fetchPhotos(PHOTO_LIMIT)
        .subscribeOn(Schedulers.io())

    private fun fetchAlbums(photos: Flowable<RawPhoto>) = photos
     //   .switchMap { response -> Observable.fromIterable(response.distinctBy { it.albumId }) }
        .flatMap { albumService.fetchAlbum(it.albumId) }

    private fun fetchUsers(albums: Flowable<RawAlbum>) = albums
        .flatMap { response -> userService.fetchUser(response.userId) }

    companion object {
        private const val PHOTO_LIMIT = 100
    }
}