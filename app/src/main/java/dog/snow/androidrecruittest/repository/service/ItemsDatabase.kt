package dog.snow.androidrecruittest.repository.service

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ListItemEntity::class],
    version = DbRoomDatabase.VERSION
)
abstract class ItemsDatabase : RoomDatabase() {

}
