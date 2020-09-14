package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.domain.interctor.BaseReactiveDisposableClass
import dog.snow.androidrecruittest.domain.interctor.ExecutableUseCase
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver

abstract class SingleCase<Results, in Params> :
    BaseReactiveDisposableClass(),
    ExecutableUseCase.Single<Results, Params> {

    abstract fun getAllLocalItems(params: Params? = null): Single<Results>

    override fun execute(
        observer: DisposableSingleObserver<Results>,
        params: Params?
    ) {
        val single = buildUseCaseSingleWithSchedulers(params)
        addDisposable(single.subscribeWith(observer))
    }

    private fun buildUseCaseSingleWithSchedulers(params: Params?): Single<Results> =
        getAllLocalItems(params)
            .subscribeOn(threadExecutorScheduler)
            .observeOn(postExecutionThreadScheduler)
}