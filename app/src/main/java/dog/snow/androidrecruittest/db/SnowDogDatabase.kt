package dog.snow.androidrecruittest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dog.snow.androidrecruittest.models.Item

@Database(entities = arrayOf(Item::class), version = 1, exportSchema = false)
abstract class SnowDogDatabase : RoomDatabase() {

    abstract fun getItemDao(): SnowDogDao

    companion object {
        @Volatile
        private var INSTANCE: SnowDogDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: getInstance(context).also { INSTANCE = it }
        }

        fun getInstance(context: Context): SnowDogDatabase? {
            if (INSTANCE == null) {
                synchronized(SnowDogDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context,
                            SnowDogDatabase::class.java, "SnowDogDatabase.db")
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
