package dog.snow.androidrecruittest.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "SnowDogItem")
data class Item(@PrimaryKey(autoGenerate = true) var id: Long, var name: String, var description: String, var icon: String, var timestamp: String, var urlIcon: String)

