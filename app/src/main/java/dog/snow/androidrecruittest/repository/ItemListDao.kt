package dog.snow.androidrecruittest.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dog.snow.androidrecruittest.repository.service.ListItemEntity
import io.reactivex.Single

@Dao
interface ListItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(listItemEntities: List<ListItemEntity>): Single<List<Long>>

    @Query("SELECT * FROM ListItemEntity")
    fun getAllItems(): Single<List<ListItemEntity>>
}