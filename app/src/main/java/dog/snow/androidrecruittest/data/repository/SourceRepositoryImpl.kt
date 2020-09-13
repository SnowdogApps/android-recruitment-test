package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.model.album.RawAlbum
import dog.snow.androidrecruittest.data.model.album.RawAlbum_
import dog.snow.androidrecruittest.data.model.photo.RawPhoto
import dog.snow.androidrecruittest.data.model.user.RawUser
import dog.snow.androidrecruittest.data.model.user.RawUser_
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
class SourceRepositoryImpl @Inject constructor(
    private val photoService: PhotoService,
    private val albumService: AlbumService,
    private val userService: UserService,
    private val photoBox: Box<RawPhoto>,     //TODO: create database manager
    private val albumBox: Box<RawAlbum>,     //TODO: create database manager
    private val userBox: Box<RawUser>     //TODO: create database manager
) : SourceRepository {

    override fun fetchData(): Single<out Resource<Void>> = photoService.fetchPhotos(PHOTO_LIMIT) // Fetch photos.
        .subscribeOn(Schedulers.io()) //TODO: split logic into methods
        .map { putPhotos(it) }
        .switchMap { response -> Flowable.fromIterable(response.distinctBy { it.albumUId }) }
        .flatMap { albumService.fetchAlbum(it.albumUId) }                                       // Fetch album.
        .map { putAlbum(it) }
        .flatMap { response -> userService.fetchUser(response.userUId) }                        // Fetch user.
        .map { putUser(it) }
        .toList()                                                                               // Group results.
        .map { Resource.Success<Void>(null) }                                             // At the time whole data is stored.
        .observeOn(AndroidSchedulers.mainThread())


    private fun putPhotos(photos: List<RawPhoto>):List<RawPhoto> =  with(photoBox) {
        removeAll()
        put(photos)
        photos
    }

    private fun putAlbum(album: RawAlbum): RawAlbum = with(albumBox) {
        query().equal(RawAlbum_.uId, album.uId.value).build().remove()
        put(album)
        album
    }

    private fun putUser(user: RawUser):  RawUser = with(userBox) {
        query().equal(RawUser_.uId, user.uId.value).build().remove()
        put(user)
        user
    }
    companion object {
        private const val PHOTO_LIMIT = 100
        private val TAG = SourceRepositoryImpl::class.simpleName
    }
}