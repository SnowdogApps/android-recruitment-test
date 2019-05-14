package dog.snow.androidrecruittest.data_repository

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dog.snow.androidrecruittest.api.SDRetrofitApi
import dog.snow.androidrecruittest.db.SDDatabase
import dog.snow.androidrecruittest.models.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class SnowDogDataRepository(val context: Context) {

    private lateinit var db: SDDatabase
    private lateinit var api: SDRetrofitApi
    private var itemList: MutableLiveData<List<Item>> = MutableLiveData()


    fun initDB() {
        if(!::db.isInitialized) {
            db = SDDatabase.getInstance(this.context)!!
        }
    }

    fun initConnection() {
        if(!::api.isInitialized) {
            api = SDRetrofitApi.create()
        }
        loadData()
    }

    fun loadData() {
        CoroutineScope(Dispatchers.IO).launch {
            var request = api.getDataFromServer()
            withContext(Dispatchers.Main) {
                try {
                    var response = request.await()
                    if (response.isSuccessful) {
                        db.getItemDao().insertAll(response.body()!!)
                        itemList = db.getItemDao().getAll()
                    } else {
                        Toast.makeText(context, "Connection error: " + response.errorBody(),Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception) {
                    e.localizedMessage
                }
            }
        }
    }

    fun getItems(): MutableLiveData<List<Item>> {
        return itemList
    }
}

