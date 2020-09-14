package dog.snow.androidrecruittest.data.source.local

import dog.snow.androidrecruittest.data.model.raw.*
import io.objectbox.Box
import javax.inject.Inject

class DatabaseManager @Inject constructor(
    private val photoBox: Box<RawPhoto>,
    private val albumBox: Box<RawAlbum>,
    private val userBox: Box<RawUser>
){
    fun putPhotos(photos: List<RawPhoto>): Unit = with(photoBox) {
        removeAll()
        put(photos)
    }

    fun putAlbum(album: RawAlbum): Unit = with(albumBox) {
        query().equal(RawAlbum_.uId, album.uId.value).build().remove() //TODO: separate query method.
        put(album)
    }

    fun putUser(user: RawUser): Unit = with(userBox) {
        query().equal(RawUser_.uId, user.uId.value).build().remove()
        put(user)
    }
}