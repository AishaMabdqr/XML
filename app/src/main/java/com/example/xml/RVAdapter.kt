package com.example.xml

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter (val itemList : ArrayList<String>) : RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var items = itemList[position]

        holder.itemView.apply{
            for(i in itemList){
                tvItem.text = items
                Log.d("RVAdapter", (items))
            }

        }
    }

    override fun getItemCount() = itemList.size
}