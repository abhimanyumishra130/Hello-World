package com.example.newsapplication.data.models

data class ResponseModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)