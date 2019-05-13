package dog.snow.androidrecruittest.data_repository

import android.content.Context
import dog.snow.androidrecruittest.api.SDRetrofitApi
import dog.snow.androidrecruittest.db.SDDatabase

class SnowDogDataRepository {

    private lateinit var db: SDDatabase
    private lateinit var api: SDRetrofitApi

    fun initDB(context: Context) {
        db = SDDatabase.getInstance(context)!!
    }

    fun intConnection() {
        api = SDRetrofitApi.create()
    }

    fun loadData() {

    }
}