package dog.snow.androidrecruittest.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import dog.snow.androidrecruittest.models.Item


@Dao
interface SDDBDao {

    @Query("SELECT * from SnowDogItem")
    fun getAll():MutableLiveData<List<Item>>

    @Insert(onConflict = REPLACE)
    fun insert(item: Item)

    @Insert(onConflict = REPLACE)
    fun insertAll(item: List<Item>)

    @Query("DELETE from snowdogitem")
    fun deleteAll()
}