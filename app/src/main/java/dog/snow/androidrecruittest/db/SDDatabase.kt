package dog.snow.androidrecruittest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dog.snow.androidrecruittest.models.Item

@Database(entities = arrayOf(Item::class), version = 1)
abstract class SDDatabase : RoomDatabase() {

    abstract fun getItemDao():SDDBDao

    companion object {
        private var INSTANCE: SDDatabase? = null

        fun getInstance(context: Context): SDDatabase? {
            if (INSTANCE == null) {
                synchronized(SDDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SDDatabase::class.java, "SDDatabase.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
