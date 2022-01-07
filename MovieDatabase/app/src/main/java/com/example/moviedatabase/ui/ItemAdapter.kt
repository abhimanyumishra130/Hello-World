package com.example.moviedatabase.data.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.moviedatabase.R
import com.example.moviedatabase.data.remote.Result


class ItemAdapter(val onClickListener: OnClickListener) : PagingDataAdapter<Result, ItemViewHolder>(diffUtil) {

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        var layoutInflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.item_list, parent, false),onClickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val result = getItem(position)
        result?.let {
            holder.setData(result)
        }

    }
}


class Item2Adapter(val onClickListener: OnClickListener) : PagingDataAdapter<Result, Item2ViewHolder>(diffUtil) {

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item2ViewHolder {

        var layoutInflater = LayoutInflater.from(parent.context)
        return Item2ViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.item_layout_up, parent, false),onClickListener)
    }

    override fun onBindViewHolder(holder: Item2ViewHolder, position: Int) {
        val result = getItem(position)
        result?.let {
            holder.setData(result)
        }

    }
}