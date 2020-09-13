package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.source.remote.Resource
import io.reactivex.Single


interface SourceRepository {
    fun pullData(): Single<out Resource<Void>>
}