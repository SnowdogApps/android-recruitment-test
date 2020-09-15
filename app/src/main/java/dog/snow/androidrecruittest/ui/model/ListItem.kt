package dog.snow.androidrecruittest.ui.model

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.model.type.common.Title
import dog.snow.androidrecruittest.data.model.type.photo.Url
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItem(
    val uId: UId,
    val title: Title,
    val albumTitle: Title,
    val thumbnailUrl: Url
) : Parcelable