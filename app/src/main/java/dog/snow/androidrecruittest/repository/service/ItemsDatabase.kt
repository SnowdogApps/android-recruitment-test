package dog.snow.androidrecruittest.repository.service

import androidx.room.Database
import androidx.room.RoomDatabase
import dog.snow.androidrecruittest.repository.ListItemDao

@Database(
    entities = [ListItemEntity::class],
    version = DbRoomDatabase.VERSION
)
abstract class ItemsDatabase : RoomDatabase() {

    abstract fun ListDaoItem(): ListItemDao
}
