package com.example.unit_5sprint1.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.unit_5sprint1.R
import com.example.unit_5sprint1.retrofit.ResponseModelItem

class ItemAdapter(var list:ArrayList<ResponseModelItem>): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val response = list[position]
        holder.setData(response)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}