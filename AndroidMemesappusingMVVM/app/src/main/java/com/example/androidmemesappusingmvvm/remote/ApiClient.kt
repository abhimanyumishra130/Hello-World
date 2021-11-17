package com.example.androidmemesappusingmvvm.remote

import com.example.androidmemesappusingmvvm.recyclerView.model.ResponseModel
import retrofit2.http.GET

interface ApiClient {

    @GET("get_memes")
    suspend fun getData():ResponseModel
}