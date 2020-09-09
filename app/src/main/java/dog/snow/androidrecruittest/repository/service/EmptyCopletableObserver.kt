package dog.snow.androidrecruittest.repository.service

import io.reactivex.observers.DisposableCompletableObserver

open class EmptyCompletableObserver : DisposableCompletableObserver() {

    override fun onComplete() {
    }

    override fun onError(throwable: Throwable) {
    }
}