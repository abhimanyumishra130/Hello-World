package com.example.moviedatabase.recyclerView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedatabase.databinding.ItemListBinding
import com.example.moviedatabase.remote.Result

class ItemViewHolder(var itemListBinding: ItemListBinding) : RecyclerView.ViewHolder(itemListBinding.root) {
    fun setData(result: Result){
        itemListBinding.result = result
        Glide.with(itemListBinding.imageItem).load("https://api.themoviedb.org/3/"+result.backdrop_path).into(itemListBinding.imageItem)
    }
}