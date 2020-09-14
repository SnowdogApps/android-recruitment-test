package dog.snow.androidrecruittest.data.source.remote.service

import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.model.raw.RawUser
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("/users/{id}")
    fun fetchUser(@Path("id") userUId: UId) : Flowable<RawUser>
}