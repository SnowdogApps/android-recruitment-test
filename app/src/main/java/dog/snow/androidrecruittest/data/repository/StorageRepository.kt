package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.model.raw.RawAlbum
import dog.snow.androidrecruittest.data.model.raw.RawPhoto
import dog.snow.androidrecruittest.data.model.raw.RawUser
import dog.snow.androidrecruittest.data.model.type.common.UId
import io.reactivex.Flowable


interface StorageRepository {
    fun getPhotos(): Flowable<RawPhoto>
    fun getAlbums(): Flowable<RawAlbum>
    fun getUsers(): Flowable<RawUser>

    fun getPhoto(photoUId: UId): Flowable<RawPhoto>
    fun getAlbumByPhotoId(photoUId: UId): Flowable<RawAlbum>
    fun getUserByPhotoId(photoUId: UId): Flowable<RawUser>
}