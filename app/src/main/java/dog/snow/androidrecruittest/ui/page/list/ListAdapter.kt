package dog.snow.androidrecruittest.ui.page.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.databinding.ItemListBinding
import dog.snow.androidrecruittest.ui.model.ListItem

class ListAdapter(private val onClick: (item: ListItem, position: Int, view: View) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<ListItem, ListAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(itemView, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    inner class ViewHolder(
        private val binding: ItemListBinding,
        private val onClick: (item: ListItem, position: Int, view: View) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItem) = with(itemView) {
            binding. apply {
                listItem = item
                binding.executePendingBindings()
            }
            setOnClickListener { onClick(item, adapterPosition, this) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListItem>() {
            override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
                oldItem.uId.value == newItem.uId.value

            override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
                oldItem == newItem
        }
    }
}