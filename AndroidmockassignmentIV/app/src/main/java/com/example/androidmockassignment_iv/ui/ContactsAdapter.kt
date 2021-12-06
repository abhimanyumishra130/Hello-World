package com.exampCle.androidmockassignment_iv.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmockassignment_iv.R
import com.example.androidmockassignment_iv.data.database.Contact
import com.example.androidmockassignment_iv.databinding.ItemLayoutBinding

class ContactsAdapter(val itemClickListener: ItemClickListener):PagingDataAdapter<Contact,ContactViewHolder>(diffUtil) {

    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<Contact>(){
            override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
                return newItem.id == oldItem.id
            }

            override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_layout,parent,false),itemClickListener)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.setData(contact!!)
    }


}

class ContactViewHolder(val itemLayoutBinding: ItemLayoutBinding,val itemClickListener: ItemClickListener):RecyclerView.ViewHolder(itemLayoutBinding.root){

    fun setData(contact: Contact){
        itemLayoutBinding.contact = contact
        itemLayoutBinding.rlContactItem.setOnClickListener {
            itemClickListener.onItemClicked(contact)
        }
    }
}

interface ItemClickListener{
    fun onItemClicked(contact:Contact)
}