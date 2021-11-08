package com.example.w45_codingevalutation.Data.remote

data class ResponseModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)