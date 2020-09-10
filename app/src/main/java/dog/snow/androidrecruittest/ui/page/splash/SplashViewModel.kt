package dog.snow.androidrecruittest.ui.page.splash

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dog.snow.androidrecruittest.data.model.photo.RawPhoto
import dog.snow.androidrecruittest.data.repository.RemoteRepository
import dog.snow.androidrecruittest.data.source.remote.Resource
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository
) : ViewModel() {
    private val _photos = MutableLiveData<Resource<List<RawPhoto>>>()
    val photos get() = _photos

    init {
        fetchPhotos()
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear() // TODO: add to base class
    }

    fun fetchPhotos() {
        disposable.add(remoteRepository.fetchPhotos()
            .subscribe(
                {},
                {}
            )
        )
    }

    companion object {
        private val TAG = SplashViewModel::class.simpleName
        private val disposable: CompositeDisposable =
            CompositeDisposable() //TODO: add to base class
    }
}