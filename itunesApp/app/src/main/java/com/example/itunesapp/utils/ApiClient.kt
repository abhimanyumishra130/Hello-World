package com.example.itunesapp.utils

import com.example.itunesapp.data.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("search")
    suspend fun getMusics(@Query("term") term:String): ResponseModel
}