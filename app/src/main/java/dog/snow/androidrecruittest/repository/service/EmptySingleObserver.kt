package dog.snow.androidrecruittest.repository.service

import io.reactivex.observers.DisposableSingleObserver

open class EmptySingleObserver<T> : DisposableSingleObserver<T>() {

    override fun onSuccess(result: T) {
    }

    override fun onError(throwable: Throwable) {
    }
}