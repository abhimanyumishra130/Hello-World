package com.example.unit_5sprint1.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.unit_5sprint1.retrofit.ResponseModel
import com.example.unit_5sprint1.retrofit.ResponseModelItem
import kotlinx.android.synthetic.main.item_list.view.*

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(responseModelItem: ResponseModelItem){
        itemView?.apply {
            itemName.text = "Name: ${responseModelItem.name}"
           if(responseModelItem.birthday!=null) itemBirthday.text = "Birthday: ${responseModelItem.birthday}"
            if(responseModelItem.deathday!=null) itemDeathday.text = "Death-day: ${responseModelItem.deathday}"
            if(responseModelItem.image!=null) Glide.with(itemImage).load(responseModelItem.image.original).into(itemImage)
            if(responseModelItem.country!=null){
                itemCountryName.text = "Country Name: ${responseModelItem.country.name}"
                itemCountryCode.text = "Country Code: ${responseModelItem.country.code}"
                itemCountryTimeZone.text = "Country Time-zone: ${responseModelItem.country.timezone}"
            }

        }
    }
}