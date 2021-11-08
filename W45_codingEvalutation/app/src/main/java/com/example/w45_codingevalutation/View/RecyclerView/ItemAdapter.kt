package com.example.w45_codingevalutation.View.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.w45_codingevalutation.Data.remote.Article
import com.example.w45_codingevalutation.R

class ItemAdapter(val list:List<Article>, val itemClickListener: ItemClickListener):RecyclerView.Adapter<VeiwHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VeiwHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return VeiwHolder(view,itemClickListener)
    }

    override fun onBindViewHolder(holder: VeiwHolder, position: Int) {
        val article = list[position]
        holder.getData(article)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}