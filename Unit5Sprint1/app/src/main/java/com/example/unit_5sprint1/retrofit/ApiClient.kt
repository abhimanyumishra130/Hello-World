package com.example.unit_5sprint1.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("people")
    fun getApiData(@Query("page") page: Int):Call<ResponseModel>
}