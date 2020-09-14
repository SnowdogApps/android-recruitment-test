package dog.snow.androidrecruittest.ui.page.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dog.snow.androidrecruittest.data.model.raw.RawAlbum
import dog.snow.androidrecruittest.data.model.raw.RawPhoto
import dog.snow.androidrecruittest.data.model.raw.RawUser
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.repository.StorageRepository
import dog.snow.androidrecruittest.ui.base.BaseViewModel
import dog.snow.androidrecruittest.ui.model.Detail
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function3
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val storageRepository: StorageRepository
) : BaseViewModel() {
    private val _details = MutableLiveData<Detail>()
    val details: LiveData<Detail> get() = _details

    fun getDetails(photoUId: UId) {
        Log.i(TAG, "Get details from db - start.")
        disposable.add(
            Flowable.zip(
                storageRepository.getPhoto(photoUId),
                storageRepository.getAlbumByPhotoId(photoUId),
                storageRepository.getUserByPhotoId(photoUId),
                Function3<RawPhoto, RawAlbum, RawUser, Detail> { photo, album, user ->
                    Detail(
                        photoUId = photo.uId,
                        photoTitle = photo.title,
                        albumTitle = album.title,
                        username = user.username,
                        email = user.email,
                        phone = user.phone,
                        url = photo.url
                    )
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        _details.value = it
                        Log.i(TAG, "Get details from db - finish.")

                    },
                    {
                        Log.e(TAG, "Get details from db - error.", it)
                    }
                )
        )
    }

    companion object {
        private val TAG = DetailsViewModel::class.simpleName
    }
}