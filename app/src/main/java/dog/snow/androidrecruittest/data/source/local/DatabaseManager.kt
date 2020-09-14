package dog.snow.androidrecruittest.data.source.local

import dog.snow.androidrecruittest.data.model.raw.*
import dog.snow.androidrecruittest.data.model.type.common.UId
import io.objectbox.Box
import io.objectbox.rx.RxQuery
import io.reactivex.Flowable
import javax.inject.Inject

class DatabaseManager @Inject constructor( //TODO: create interface
    private val photoBox: Box<RawPhoto>,
    private val albumBox: Box<RawAlbum>,
    private val userBox: Box<RawUser>
){
    fun putPhotos(photos: List<RawPhoto>): Unit = with(photoBox) {
        removeAll()
        put(photos)
    }

    fun putAlbum(album: RawAlbum): Unit = with(albumBox) {
        query().equal(RawAlbum_.uId, album.uId.value).build().remove()
        put(album)
    }

    fun putUser(user: RawUser): Unit = with(userBox) {
        query().equal(RawUser_.uId, user.uId.value).build().remove()
        put(user)
    }

    fun getPhotos(): Flowable<RawPhoto> = RxQuery.flowableOneByOne(photoBox.query().build())

    fun getPhoto(photoUId: UId): Flowable<RawPhoto> =
        RxQuery.flowableOneByOne(photoBox.query().equal(RawPhoto_.uId, photoUId.value).build())

    fun getAlbum(albumUid: UId): Flowable<RawAlbum> =
        RxQuery.flowableOneByOne(albumBox.query().equal(RawAlbum_.uId, albumUid.value).build())

    fun getUser(userUId: UId): Flowable<RawUser> =
        RxQuery.flowableOneByOne(userBox.query().equal(RawUser_.uId, userUId.value).build())
}