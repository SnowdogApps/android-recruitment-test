package dog.snow.androidrecruittest.ui.page.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dog.snow.androidrecruittest.data.model.raw.RawAlbum
import dog.snow.androidrecruittest.data.model.raw.RawPhoto
import dog.snow.androidrecruittest.data.repository.StorageRepository
import dog.snow.androidrecruittest.ui.base.BaseViewModel
import dog.snow.androidrecruittest.ui.model.ListItem
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function3
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val storageRepository: StorageRepository
) : BaseViewModel() {
    private val _listItems = MutableLiveData<List<ListItem>>()
    val listItems: LiveData<List<ListItem>> get() = _listItems

    init {
        getData()
    }

    /** Utils. */

    private fun getData() {
        Log.i(TAG, "Get data from db - start.")
        disposable.add(
            Flowable.zip(storageRepository.getPhotos(), storageRepository.getAlbums(),
                BiFunction<RawPhoto, RawAlbum, ListItem> { photo, album ->
                    ListItem(photo.uId, photo.title, album.title, photo.thumbnailUrl)
                })
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        _listItems.value = it
                        Log.i(TAG, "Get data from db - finish. List size: ${it.size}")
                    }, {
                        _listItems.value = listOf()
                        Log.e(TAG, "Get data from db - error.", it)
                    })
        )
    }

    companion object {
        private val TAG = ListViewModel::class.simpleName
    }
}