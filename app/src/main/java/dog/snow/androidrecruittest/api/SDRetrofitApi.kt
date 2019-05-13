package dog.snow.androidrecruittest.api

import com.google.gson.GsonBuilder
import dog.snow.androidrecruittest.models.Item
import dog.snow.androidrecruittest.utils.Constance
import retrofit2.Callback
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SDRetrofitApi {

    @GET("/api/")
    fun getDataFromServer(): Callback<List<Item>>

    companion object {
        fun create(): SDRetrofitApi {
            val gson = GsonBuilder()
                    .setLenient()
                    .create()
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(Constance.BASE_URL)
                    .build()
            return retrofit.create(SDRetrofitApi::class.java)
        }
    }
}