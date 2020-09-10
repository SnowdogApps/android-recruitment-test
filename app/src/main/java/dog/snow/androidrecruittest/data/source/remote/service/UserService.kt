package dog.snow.androidrecruittest.data.source.remote.service

import dog.snow.androidrecruittest.data.model.common.Id
import dog.snow.androidrecruittest.data.model.user.RawUser
import dog.snow.androidrecruittest.data.source.remote.Resource
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("/users/{id}")
    fun fetchUser(@Path("id") userId: Id) : Observable<Resource<RawUser>>
}