package dog.snow.androidrecruittest.repository.service

import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver

interface ExecutableUseCase {

    interface Single<Results, in Params> {
        fun execute(
            observer: DisposableSingleObserver<Results> = EmptySingleObserver(),
            params: Params? = null
        )
    }

    interface Observable<Results, in Params> {
        fun execute(
            observer: DisposableObserver<Results> = EmptyObserver<Results>(),
            params: Params? = null
        )
    }
}