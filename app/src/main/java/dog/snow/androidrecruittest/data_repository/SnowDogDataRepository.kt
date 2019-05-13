package dog.snow.androidrecruittest.data_repository

import android.content.Context
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
        db = SDDatabase.getInstance(this.context)!!
    }

    fun initConnection() {
        api = SDRetrofitApi.create()
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

                    }
                } catch (e: Exception) {
                    e.localizedMessage
                }
            }
        }
    }

    fun getItems(): LiveData<List<Item>> {
        return itemList
    }
}

