package dog.snow.androidrecruittest.data_repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dog.snow.androidrecruittest.models.Item

private const val TAG = "SnowDogViewModel"

class SnowDogViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: SnowDogDataRepository
    private var itemList: LiveData<List<Item>>
    private var itemListSearch: LiveData<List<Item>>

    init {
        repository = SnowDogDataRepository(application.applicationContext)
        repository.initDB()
        repository.initConnection()
        itemList = repository.getItems()
        itemListSearch = repository.getSearchItems()
    }

    fun getItemList(): LiveData<List<Item>> {
        Log.d(TAG, "getItemList")
        return itemList
    }

    fun getSearchResult(): LiveData<List<Item>> {
        Log.d(TAG, "getSearchResult")
        return itemListSearch
    }

    fun loadData() {
        repository.loadData()
    }

    fun searchDB(search: String) {
        repository.searchDao(search)
        itemListSearch = repository.getSearchItems()
    }
}
