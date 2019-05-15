package dog.snow.androidrecruittest.data_repository

import android.content.Context
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
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
    private lateinit var data:LiveData<List<Item>>


    fun initDB() {
        Log.d(TAG, "initDB")
        if (!::db.isInitialized) {
            db = SnowDogDatabase.getInstance(context)!!
        }
        itemList = db.getItemDao().getAll()
        data = db.getItemDao().getAll("1")
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
                        withContext(Dispatchers.Default) {
                            db.getItemDao().insertAll(response.body())
                        }
                        withContext(Dispatchers.Default) {
                            itemList = db.getItemDao().getAll().getDistinct()
                        }
                        Log.d(TAG, "loadData: " + response.message())
                    } else {
                        Log.e(TAG, "loadData: error :" + response.message())
                    }
                } catch (e: Exception) {
                    e.localizedMessage
                    Log.e(TAG, "loadData: error try:" + e.localizedMessage)
                }
            }
        }
    }

      fun searchDao(search: String) {
        Log.d(TAG, "searchDao")
        var searchDao = "%$search%"
          CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Default) {
                try {

                    data = db.getItemDao().getAll(searchDao).getDistinct()
//                Log.d(TAG, "searchDao: dbResult " + db.getItemDao().getAll(searchDao).getDistinct())

                } catch (e: Exception) {
                    e.localizedMessage
                    Log.e(TAG, "searchDao: error try:" + e.localizedMessage)

                }
            }
        }
    }

    fun getItems(): LiveData<List<Item>> {
        Log.d(TAG, "getItems")
        return itemList
    }
    fun getSearchItems(): LiveData<List<Item>> {
        Log.d(TAG, "getSearchItems")
        return data
    }

    fun <T> LiveData<T>.getDistinct(): LiveData<T> {
        val distinctLiveData = MediatorLiveData<T>()
        distinctLiveData.addSource(this, object : Observer<T> {
            private var initialized = false
            private var lastObj: T? = null
            override fun onChanged(obj: T?) {
                if (!initialized) {
                    initialized = true
                    lastObj = obj
                    distinctLiveData.postValue(lastObj)
                } else if ((obj == null && lastObj != null)
                        || obj != lastObj) {
                    lastObj = obj
                    distinctLiveData.postValue(lastObj)
                }
            }
        })
        return distinctLiveData
    }
}

