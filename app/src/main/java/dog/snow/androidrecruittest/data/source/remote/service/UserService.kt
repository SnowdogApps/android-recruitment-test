package dog.snow.androidrecruittest.data.source.remote.service

import dog.snow.androidrecruittest.data.model.common.UId
import dog.snow.androidrecruittest.data.model.user.RawUser
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("/users/{id}")
    fun fetchUser(@Path("id") userUId: UId) : Flowable<RawUser>
}