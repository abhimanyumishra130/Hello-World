package com.example.newsapplication.ui.clickListener

import com.example.newsapplication.data.models.Article

interface NewsClickListener {

    fun itemClicked(article: Article)
}