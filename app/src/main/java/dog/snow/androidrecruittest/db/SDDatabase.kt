package dog.snow.androidrecruittest.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import dog.snow.androidrecruittest.models.Item

@Database(entities = arrayOf(Item::class), version = 1)
abstract class SDDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: SDDatabase? = null

        fun getInstance(context: Context): SDDatabase? {
            if (INSTANCE == null) {
                synchronized(SDDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SDDatabase::class.java, "weather.db")
                            .build()
                }
            }
            return INSTANCE
        }
s
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
