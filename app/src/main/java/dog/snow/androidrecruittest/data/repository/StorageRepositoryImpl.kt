package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.model.raw.RawAlbum
import dog.snow.androidrecruittest.data.model.raw.RawPhoto
import dog.snow.androidrecruittest.data.model.raw.RawUser
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.source.local.DatabaseManager
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    private val databaseManager: DatabaseManager
) : StorageRepository {

    /** Lists. */


    override fun getPhotos(): Flowable<RawPhoto> = databaseManager.getPhotos()
        .subscribeOn(Schedulers.newThread())

    override fun getAlbums(): Flowable<RawAlbum> = getPhotos()
        .subscribeOn(Schedulers.newThread())
        .concatMap { databaseManager.getAlbum(it.albumUId) }

    override fun getUsers(): Flowable<RawUser> = getAlbums()
        .subscribeOn(Schedulers.newThread())
        .concatMap { databaseManager.getUser(it.userUId) }

    /** Single values. */

    override fun getPhoto(photoUId: UId): Flowable<RawPhoto> = databaseManager.getPhoto(photoUId)
        .subscribeOn(Schedulers.newThread())

    override fun getAlbumByPhotoId(photoUId: UId): Flowable<RawAlbum> = getPhoto(photoUId)
        .subscribeOn(Schedulers.newThread())
        .concatMap { databaseManager.getAlbum(it.albumUId) }

    override fun getUserByPhotoId(photoUId: UId): Flowable<RawUser> = getAlbumByPhotoId(photoUId)
        .subscribeOn(Schedulers.newThread())
        .concatMap { databaseManager.getUser(it.userUId) }
}