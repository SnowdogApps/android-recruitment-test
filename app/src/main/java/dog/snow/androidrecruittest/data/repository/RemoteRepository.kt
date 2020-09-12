package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.source.remote.Resource
import io.reactivex.Flowable
import io.reactivex.Single


interface RemoteRepository {
    fun fetchData(): Flowable<Resource<Void>>
}