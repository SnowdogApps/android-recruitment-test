package dog.snow.androidrecruittest.ui.page.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dog.snow.androidrecruittest.data.repository.SourceRepository
import dog.snow.androidrecruittest.data.source.remote.Resource
import dog.snow.androidrecruittest.ui.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val sourceRepository: SourceRepository
) : BaseViewModel() {
    private val _fetchDataState = MutableLiveData<Resource<Void>>()
    val fetchDataState: LiveData<Resource<Void>> get() = _fetchDataState

    init {
        fetchData()
    }

    fun fetchData() {
        Log.i(TAG, "Fetch data - start. ")
        _fetchDataState.value = Resource.Loading(null)
        disposable.add(sourceRepository.pullData()
            .subscribe(
                {
                    _fetchDataState.value = it
                    Log.i(TAG, "Fetch data - finished.")
                },
                {
                    _fetchDataState.value = Resource.create(it)
                    Log.e(TAG, "Fetch data - error. ", it)
                }
            )
        )
    }

    companion object {
        private val TAG = SplashViewModel::class.simpleName
    }
}