package dog.snow.androidrecruittest.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
    companion object {
        val disposable: CompositeDisposable = CompositeDisposable()
    }
}