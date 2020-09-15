package dog.snow.androidrecruittest.domain.interctor

import io.reactivex.observers.DisposableObserver

open class EmptyObserver<T> : DisposableObserver<T>() {

    override fun onNext(t: T) {}

    override fun onError(e: Throwable) {}

    override fun onComplete() {}
}