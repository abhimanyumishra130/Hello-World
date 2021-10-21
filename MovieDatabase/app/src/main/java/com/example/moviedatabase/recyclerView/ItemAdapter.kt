package com.example.moviedatabase.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.moviedatabase.R
import com.example.moviedatabase.databinding.ItemListBinding
import com.example.moviedatabase.remote.Result


class ItemAdapter : PagingDataAdapter<Result, ItemViewHolder>(diffUtil) {

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
        var itemListBinding: ItemListBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_list, parent, false)
        return ItemViewHolder(itemListBinding)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val result = getItem(position)
        result?.let {
            holder.setData(result)
        }

    }
}