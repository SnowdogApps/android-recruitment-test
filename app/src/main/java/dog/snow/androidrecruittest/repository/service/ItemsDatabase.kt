package dog.snow.androidrecruittest.repository.service

import androidx.room.Database
import androidx.room.RoomDatabase
import dog.snow.androidrecruittest.db.entity.ListItemEntity
import dog.snow.androidrecruittest.db.dao.ListItemDao

@Database(
    entities = [ListItemEntity::class],
    version = DbRoomDatabase.VERSION
)
abstract class ItemsDatabase : RoomDatabase() {

    abstract fun ListDaoItem(): ListItemDao
}
