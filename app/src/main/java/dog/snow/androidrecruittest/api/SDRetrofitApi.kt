package dog.snow.androidrecruittest.api

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dog.snow.androidrecruittest.models.Item
import dog.snow.androidrecruittest.utils.Constance
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SDRetrofitApi {

    @GET("/api/list")
    fun getDataFromServer(): Deferred<Response<List<Item>>>

    companion object {
        fun create(): SDRetrofitApi {
            val gson = GsonBuilder()
                    .setLenient()
                    .create()
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(Constance.BASE_URL)
                    .build()
            return retrofit.create(SDRetrofitApi::class.java)
        }
    }
}