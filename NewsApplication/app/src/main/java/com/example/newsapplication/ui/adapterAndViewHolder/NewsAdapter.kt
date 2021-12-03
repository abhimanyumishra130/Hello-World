package com.example.newsapplication.ui.adapterAndViewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.DataBindingUtil
import com.example.newsapplication.data.models.Article
import com.bumptech.glide.Glide
import com.example.newsapplication.R
import com.example.newsapplication.databinding.NewsItemLayoutBinding
import com.example.newsapplication.ui.clickListener.NewsClickListener

class NewsAdapter (private val list: ArrayList<Article>,val newsClickListener: NewsClickListener): RecyclerView.Adapter<NewsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.news_item_layout,parent,false),newsClickListener)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = list[position]
        holder.setData(article)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class NewsViewHolder(val newsItemLayoutBinding: NewsItemLayoutBinding,val newsClickListener: NewsClickListener) :RecyclerView.ViewHolder(newsItemLayoutBinding.root){

    fun setData(article: Article){
        newsItemLayoutBinding.article = article
        Glide.with(newsItemLayoutBinding.newsImage).load(article.urlToImage).into(newsItemLayoutBinding.newsImage)
        newsItemLayoutBinding.newsItem.setOnClickListener {
            newsClickListener.itemClicked(article)
        }
    }
}