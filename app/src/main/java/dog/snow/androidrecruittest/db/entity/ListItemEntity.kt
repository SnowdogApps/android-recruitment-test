package dog.snow.androidrecruittest.db.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dog.snow.androidrecruittest.repository.service.DbConstans

@Entity
data class ListItemEntity(

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = DbConstans.ID) val id: Long,
    @ColumnInfo(name = DbConstans.USER_ID) val userId: Long,
    @ColumnInfo(name = DbConstans.TITLE) val title: String,
    @ColumnInfo(name = DbConstans.ALBUM_TITLE) val albumTitle: String,
    @ColumnInfo(name = DbConstans.USERNAME) val username: String,
    @ColumnInfo(name = DbConstans.EMAIL) val email: String,
    @ColumnInfo(name = DbConstans.PHONE) val phone: String,
    @ColumnInfo(name = DbConstans.URL) val url: String,
    @ColumnInfo(name = DbConstans.THUMBNAIL_URL) val thumbnailUrl: String
)