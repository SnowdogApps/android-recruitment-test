package dog.snow.androidrecruittest.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.lifecycle.MutableLiveData
import androidx.room.OnConflictStrategy
import dog.snow.androidrecruittest.models.Item


@Dao
interface SnowDogDao {

//    @Query("SELECT * from Item")
//    fun getAll(): LiveData<List<Item>>

    @Query("SELECT * FROM Item WHERE name LIKE :search OR description LIKE :search")
    fun getAll(search:String="%"): LiveData<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Item)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(item: List<Item>?)

    @Query("DELETE from Item")
    fun deleteAll()

//    @Query("SELECT 1 from Item")
//    fun getEmpty(): LiveData<List<Item>>
}