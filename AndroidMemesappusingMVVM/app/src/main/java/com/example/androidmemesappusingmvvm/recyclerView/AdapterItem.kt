package com.example.androidmemesappusingmvvm.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidmemesappusingmvvm.R
import com.example.androidmemesappusingmvvm.databinding.ItemLayoutBinding
import com.example.androidmemesappusingmvvm.recyclerView.model.Meme

class AdapterItem:PagingDataAdapter<Meme,ItemViewHolder>(diffUtil) {

    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<Meme>(){
            override fun areItemsTheSame(oldItem: Meme, newItem: Meme): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Meme, newItem: Meme): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = getItem(position)
        data?.let {
            holder.setData(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_layout,parent,false))
    }
}

class ItemViewHolder(var itemLayoutBinding: ItemLayoutBinding):RecyclerView.ViewHolder(itemLayoutBinding.root){

    fun setData( meme: Meme){
        itemLayoutBinding.meme = meme
        Glide.with(itemLayoutBinding.imageItem).load(meme.url).into(itemLayoutBinding.imageItem)
    }
}