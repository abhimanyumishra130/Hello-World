package com.example.w45_codingevalutation.View.RecyclerView

import com.example.w45_codingevalutation.Data.remote.Article
import com.example.w45_codingevalutation.Data.remote.ResponseModel

interface ItemClickListener {
    fun onItemClicked(article: Article)
}