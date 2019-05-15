package dog.snow.androidrecruittest.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.models.Item
import kotlin.collections.ArrayList


class SnowDogListAdapter(val context: Context) : RecyclerView.Adapter<SnowDogListAdapter.SDViewHolder>() {

    var itemList: List<Item> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SDViewHolder {
        return SDViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: SDViewHolder, position: Int) {
        holder.onBind(itemList.get(position))
    }

    fun setItemList(list: ArrayList<Item>) {
        itemList = list
        notifyDataSetChanged()
    }

    fun clearList() {
        itemList = listOf()
        notifyDataSetChanged()
    }

    class SDViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var itemImg: ImageView = view.findViewById(R.id.item_avatar)
        var itemTitle: TextView = view.findViewById(R.id.item_title)
        var itemDescription: TextView = view.findViewById(R.id.item_description)

        fun onBind(item: Item) {
            itemTitle.text = item.name
            itemDescription.text = item.description
            Picasso.get().load(item.icon).into(itemImg)
        }
    }

}