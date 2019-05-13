package dog.snow.androidrecruittest.db


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import dog.snow.androidrecruittest.models.Item


@Dao
interface SDDBDao {

    @Query("SELECT * from SnowDogItem")
    fun getAll(): List<Item>

    @Insert(onConflict = REPLACE)
    fun insert(item: Item)

    @Query("DELETE from snowdogitem")
    fun deleteAll()
}