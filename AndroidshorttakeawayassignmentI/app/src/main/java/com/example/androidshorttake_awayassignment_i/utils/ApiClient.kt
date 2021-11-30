package com.example.androidshorttake_awayassignment_i.utils

import com.example.androidshorttake_awayassignment_i.data.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {

    @GET("compassLocation/rest/address/autocomplete?queryString=airtel")
    suspend fun getAddresses(@Query("city") city:String):ResponseModel
}