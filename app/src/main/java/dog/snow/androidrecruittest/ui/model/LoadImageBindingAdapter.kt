package dog.snow.androidrecruittest.ui.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.data.model.type.photo.Url
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

object LoadImageBindingAdapter{ // TODO: create binding module
    @BindingAdapter("avatar")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: Url?) {
        Picasso.get()
            .load(url?.value)
            .placeholder(R.drawable.ic_placeholder)
            .centerCrop()
            .resize(850, 850)
            .transform(RoundedCornersTransformation(40, 0))
            .into(imageView)
    }
}