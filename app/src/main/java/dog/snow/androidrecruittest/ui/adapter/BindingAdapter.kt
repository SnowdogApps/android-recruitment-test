package dog.snow.androidrecruittest.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.extensions.ItemClickedListener
import dog.snow.androidrecruittest.repository.service.ListItem

class BindingAdapter {

    companion object {
        private val listItemsAdapter: ListItemsAdapter = ListItemsAdapter()

        @JvmStatic
        @BindingAdapter("android:imageUrl")
        fun loadImage(
            imageView: ImageView,
            imageUrl: String?
        ) {
            if (imageUrl == null) return

            Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.ic_placeholder)
                .into(imageView)
        }

        @JvmStatic
        @BindingAdapter("android:photosList", "android:itemClickListener")
        fun setPhotosList(
            recyclerView: RecyclerView,
            photos: List<ListItem>?,
            itemClickedListener: ItemClickedListener?
        ) {
            if (photos == null || itemClickedListener == null) return

            listItemsAdapter.run {
                submitList(photos)
                itemsClickedListener = itemClickedListener
            }

            recyclerView.run {
                adapter =
                    listItemsAdapter
                setHasFixedSize(true)
            }
        }
    }
}