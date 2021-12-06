package com.example.newsapplication.utils

import com.example.newsapplication.data.models.ResponseModel
import retrofit2.http.GET

interface ApiService {

    @GET("everything?q=tesla&from=2021-11-06&apiKey=2890a5db9eb84ba09f6880b22c992edc")
    suspend fun getApiData():ResponseModel
}