package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.source.remote.Resource
import io.reactivex.Single


interface RemoteRepository {
    fun fetchData(): Single<Resource<Void>>
}