package dog.snow.androidrecruittest.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "SnowDogItem")
data class Item(@PrimaryKey(autoGenerate = true) var id: Long, var name: String, var description: String, var icon: String, var timestamp: String, var urlIcon: String)

