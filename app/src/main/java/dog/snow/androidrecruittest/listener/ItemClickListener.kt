package dog.snow.androidrecruittest.listener

import android.widget.ImageView
import dog.snow.androidrecruittest.repository.service.ListItem

interface ItemClickedListener {

    fun onItemRowClicked(listItem: ListItem, imageView: ImageView)
}