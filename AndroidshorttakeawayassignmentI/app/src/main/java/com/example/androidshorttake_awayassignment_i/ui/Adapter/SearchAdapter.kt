package com.example.androidshorttake_awayassignment_i.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidshorttake_awayassignment_i.R
import com.example.androidshorttake_awayassignment_i.data.model.Address
import com.example.androidshorttake_awayassignment_i.databinding.SearchItemLayoutBinding

class SearchAdapter(val list:List<Address>):RecyclerView.Adapter<SearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.search_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val address = list[position]
        holder.setData(address)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class SearchViewHolder(val searchItemLayoutBinding: SearchItemLayoutBinding):RecyclerView.ViewHolder(searchItemLayoutBinding.root){

    fun setData(address: Address){
        searchItemLayoutBinding.address = address
    }
}