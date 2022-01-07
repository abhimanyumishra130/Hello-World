package com.example.moviedatabase.data.recyclerView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedatabase.databinding.ItemLayoutUpBinding
import com.example.moviedatabase.databinding.ItemListBinding
import com.example.moviedatabase.data.remote.Result

class ItemViewHolder(var itemListBinding: ItemListBinding, val onClickListener: OnClickListener) : RecyclerView.ViewHolder(itemListBinding.root) {
    fun setData(result: Result){
            Glide.with(itemListBinding.imageItem).load("https://image.tmdb.org/t/p/w500/"+result.backdrop_path).into(itemListBinding.imageItem)
        itemListBinding.gridItem.setOnClickListener {
            onClickListener.onItemClicked(result)
        }
    }
}

class Item2ViewHolder(var itemListBinding: ItemLayoutUpBinding,val onClickListener: OnClickListener) : RecyclerView.ViewHolder(itemListBinding.root) {
    fun setData(result: Result){
            Glide.with(itemListBinding.item2Image).load("https://image.tmdb.org/t/p/w500/"+result.backdrop_path).into(itemListBinding.item2Image)
        itemListBinding.upItem.setOnClickListener {
            onClickListener.onItemClicked(result)
        }
    }
}

interface OnClickListener{
    fun onItemClicked(result: Result)
}