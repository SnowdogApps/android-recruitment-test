package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.RawUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("users/{id}")
    fun getUsers(@Path("id") userId: Int): Call<List<RawUser>>

}