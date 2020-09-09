package dog.snow.androidrecruittest.repository.service

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class BaseReactiveDisposableClass : Disposable {

    protected val threadExecutorScheduler: Scheduler = Schedulers.io()

    protected val postExecutionThreadScheduler: Scheduler = AndroidSchedulers.mainThread()

    private val disposables = CompositeDisposable()

    override fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    override fun isDisposed() = disposables.isDisposed

    protected fun addDisposable(disposable: Disposable) =
        disposables.add(disposable)

}