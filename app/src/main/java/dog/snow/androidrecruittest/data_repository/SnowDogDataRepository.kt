package dog.snow.androidrecruittest.data_repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import dog.snow.androidrecruittest.api.SDRetrofitApi
import dog.snow.androidrecruittest.db.SnowDogDatabase
import dog.snow.androidrecruittest.models.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception


private const val TAG = "SnowDogDataRepository"

class SnowDogDataRepository(val context: Context) {

    private lateinit var db: SnowDogDatabase
    private lateinit var api: SDRetrofitApi
    private lateinit var itemList: LiveData<List<Item>>


    fun initDB() {
        Log.d(TAG, "initDB")
        if (!::db.isInitialized) {
            db = SnowDogDatabase.getInstance(context)!!
        }
        itemList = db.getItemDao().getAll()
    }

    fun initConnection() {
        Log.d(TAG, "initConnection")
        if (!::api.isInitialized) {
            api = SDRetrofitApi.create()
        }
    }

    fun loadData() {
        Log.d(TAG, "loadData")
        CoroutineScope(Dispatchers.IO).launch {
            var request = api.getDataFromServer()
            withContext(Dispatchers.Default) {
                try {
                    var response = request.await()
                    if (response.isSuccessful) {
                        response.body()?.let { db.getItemDao().insertAll(it) }
                        itemList = db.getItemDao().getAll()
                        Log.d(TAG, "loadData: " + response.message())
                    } else {
                        Toast.makeText(context, "Connection error: " + response.errorBody(), Toast.LENGTH_LONG).show()
                        Log.e(TAG, "loadData: error :" + response.message())
                    }
                } catch (e: Exception) {
                    e.localizedMessage
                    Log.e(TAG, "loadData: error try:" + e.localizedMessage)
                }
            }
        }
    }

    suspend fun searchDao(search:String){
        Log.d(TAG, "searchDao")

            withContext(Dispatchers.Default) {
                try {
                        itemList = db.getItemDao().getSearch(search)
                        Log.d(TAG, "searchDao: dbResult ")

                } catch (e: Exception) {
                    e.localizedMessage
                    Log.e(TAG, "loadData: error try:" + e.localizedMessage)
                }
            }

    }

    fun getItems(): LiveData<List<Item>> {
        Log.d(TAG, "getItems")
        return itemList
    }
}

