package dog.snow.androidrecruittest.data_repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dog.snow.androidrecruittest.models.Item

private const val TAG ="SnowDogViewModel"
class SnowDogViewModel(application: Application) :AndroidViewModel(application){

   private var repository:SnowDogDataRepository
   private lateinit var itemList: LiveData<List<Item>>
    init {
        repository = SnowDogDataRepository(application.applicationContext)
        repository.initDB()
        repository.initConnection()
        itemList = repository.getItems()
    }
    fun getItemList():LiveData<List<Item>>{
        Log.d(TAG,"getItemList")
        return itemList
    }

    fun loadData() {
        repository.loadData()
    }

    suspend fun searchDB(search: String) {
        repository.searchDao(search)
    }
}
