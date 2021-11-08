package com.example.w45_codingevalutation.Data.remote

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {

    @GET("everything?q=latest breaking news&sortBy=publishedAt&apiKey=2890a5db9eb84ba09f6880b22c992edc")
    fun getData():Call<ResponseModel>

    @GET("everything?q=latest breaking news&sortBy=date&apiKey=2890a5db9eb84ba09f6880b22c992edc")
    fun getSortedData():Call<ResponseModel>

    @GET("everything?sortBy=publishedAt&apiKey=2890a5db9eb84ba09f6880b22c992edc")
    fun getViaSearchData(@Query("q") search:String):Call<ResponseModel>
}