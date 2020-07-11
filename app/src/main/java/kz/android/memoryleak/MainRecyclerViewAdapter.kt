package kz.android.memoryleak

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_main.view.*

class MainRecyclerViewAdapter(
    private val onItemClickListener: (() -> Unit)? = null
) : RecyclerView.Adapter<MainRecyclerViewHolder>() {

    private val items = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_main, parent, false)
        return MainRecyclerViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainRecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(items: List<String>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}

class MainRecyclerViewHolder(
    itemView: View,
    private val onItemClickListener: (() -> Unit)? = null
) : RecyclerView.ViewHolder(itemView) {

    @SuppressLint("SetTextI18n")
    fun bind(item: String) {
        itemView.textView.text = item
        itemView.setOnClickListener {
            onItemClickListener?.invoke()
        }
    }
}