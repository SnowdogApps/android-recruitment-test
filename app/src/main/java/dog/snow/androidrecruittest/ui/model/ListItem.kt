package dog.snow.androidrecruittest.ui.model

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.model.type.common.Title
import dog.snow.androidrecruittest.data.model.type.photo.Url
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItem(
    val uId: UId,
    val title: Title,
    val albumTitle: Title,
    val thumbnailUrl: Url
) : Parcelable {

    companion object { // TODO: create binding module
        @BindingAdapter("avatar")
        @JvmStatic
        fun loadImage(imageView: ImageView, url: Url?) {
            Picasso.get()
                .load(url?.value)
                //.centerCrop()
                //.resize(850, 850)
                //.transform(RoundedCornersTransformation(40, 0))
                .into(imageView)
        }
    }
}