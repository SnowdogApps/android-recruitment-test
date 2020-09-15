package dog.snow.androidrecruittest.ui.page.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dog.snow.androidrecruittest.databinding.ItemListBinding
import dog.snow.androidrecruittest.ui.model.ListItem
import java.util.*

class ListAdapter(private val onClick: (item: ListItem, position: Int, view: View) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<ListItem, ListAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {
    private var originalList: List<ListItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(itemView, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    fun filter(text: String?) {
        if (text.isNullOrBlank()) {
            submitList(originalList)
            return
        }
        val filteredList = originalList?.filter {
            checkIfContains(it.title.value, text.toLowerCase(Locale.getDefault()))
                    || checkIfContains(it.albumTitle.value, text.toLowerCase(Locale.getDefault()))
        }
        submitList(filteredList)
    }

    fun modifyList(listItems: List<ListItem>) {
        originalList = listItems
        submitList(listItems)
    }

    private fun checkIfContains(value: String, text: String) =
        value.toLowerCase(Locale.getDefault()).contains(text)


    inner class ViewHolder(
        private val binding: ItemListBinding,
        private val onClick: (item: ListItem, position: Int, view: View) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItem) = with(itemView) {
            binding.apply {
                listItem = item
                ivThumb.transitionName = item.uId.toString()
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