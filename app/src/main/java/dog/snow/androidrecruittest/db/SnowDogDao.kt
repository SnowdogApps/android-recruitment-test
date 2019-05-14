package dog.snow.androidrecruittest.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.lifecycle.MutableLiveData
import dog.snow.androidrecruittest.models.Item


@Dao
interface SnowDogDao {

    @Query("SELECT * from SnowDogItem")
    fun getAll(): LiveData<List<Item>>

    @Insert(onConflict = REPLACE)
    fun insert(item: Item)

    @Insert(onConflict = REPLACE)
    fun insertAll(item: List<Item>)

    @Query("DELETE from SnowDogItem")
    fun deleteAll()
}