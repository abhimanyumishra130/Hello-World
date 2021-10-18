package com.example.unit_5sprint1.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.unit_5sprint1.RoomDatabase.Model
import com.example.unit_5sprint1.retrofit.ResponseModel
import com.example.unit_5sprint1.retrofit.ResponseModelItem
import kotlinx.android.synthetic.main.item_list.view.*

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(responseModelItem: Model){
        itemView?.apply {
            itemName.text = "Name: ${responseModelItem.name}"
           if(!responseModelItem.birthDay.equals("0")) itemBirthday.text = "Birthday: ${responseModelItem.birthDay}"
            if(!responseModelItem.deathday.equals("0")) itemDeathday.text = "Death-day: ${responseModelItem.deathday}"
            if(!responseModelItem.imageUrl.equals("0")) Glide.with(itemImage).load(responseModelItem.imageUrl).into(itemImage)
            if(!responseModelItem.countryCode.equals("0")){
                itemCountryName.text = "Country Name: ${responseModelItem.countryName}"
                itemCountryCode.text = "Country Code: ${responseModelItem.countryCode}"
                itemCountryTimeZone.text = "Country Time-zone: ${responseModelItem.timeZone}"
            }

        }
    }
}