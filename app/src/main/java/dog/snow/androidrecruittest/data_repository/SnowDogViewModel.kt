package dog.snow.androidrecruittest.data_repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import dog.snow.androidrecruittest.models.Item

class SnowDogViewModel(application: Application) :AndroidViewModel(application){

   private var repository:SnowDogDataRepository
    var itemList:LiveData<List<Item>>
    init {
        repository = SnowDogDataRepository(application.applicationContext)
        repository.initDB()
        repository.initConnection()
        itemList = repository.getItems()
    }
}