package dog.snow.androidrecruittest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dog.snow.androidrecruittest.models.Item

@Database(entities = arrayOf(Item::class), version = 1, exportSchema = false)
abstract class SDDatabase : RoomDatabase() {

    abstract fun getItemDao(): SnowDogDao

    companion object {
        @Volatile
        private var INSTANCE: SDDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: getInstance(context).also { INSTANCE = it }
        }

        fun getInstance(context: Context): SDDatabase? {
            if (INSTANCE == null) {
                synchronized(SDDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context,
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
