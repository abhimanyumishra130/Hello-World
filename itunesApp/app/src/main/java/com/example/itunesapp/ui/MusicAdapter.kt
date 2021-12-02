package com.example.itunesapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.itunesapp.R
import com.example.itunesapp.data.model.MusicTable
import com.example.itunesapp.databinding.MusicItemLayoutBinding

class MusicAdapter(val list:ArrayList<MusicTable>) :RecyclerView.Adapter<MusicViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.music_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val result = list[position]
        holder.setData(result)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class MusicViewHolder(val musicItemLayoutBinding: MusicItemLayoutBinding):RecyclerView.ViewHolder(musicItemLayoutBinding.root){

    fun setData(result: MusicTable){
        musicItemLayoutBinding.result = result
        Glide.with(musicItemLayoutBinding.imgItem).load(result.artworkUrl30).into(musicItemLayoutBinding.imgItem)
    }
}