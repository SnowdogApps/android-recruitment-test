package dog.snow.androidrecruittest.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
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