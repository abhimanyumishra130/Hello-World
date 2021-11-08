package com.example.w45_codingevalutation.View.RecyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.w45_codingevalutation.Data.remote.Article
import com.example.w45_codingevalutation.Data.remote.ResponseModel
import kotlinx.android.synthetic.main.item_layout.view.*

class VeiwHolder(itemView: View, val itemClickListener: ItemClickListener): RecyclerView.ViewHolder(itemView) {

    fun getData(article: Article){
        itemView?.apply {
            Glide.with(articleImage).load(article.urlToImage).into(articleImage)
            titleItem.text = article.title
            dateItem.text = article.publishedAt
            descItem.text = article.description
            item.setOnClickListener {
                itemClickListener.onItemClicked(article)
            }
        }
    }
}