package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.RawUser
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("users/{userId}")
    fun getUser(
        @Path("userId") userId: Long
    ): Single<RawUser>
}
