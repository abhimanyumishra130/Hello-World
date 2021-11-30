package com.example.androidshorttake_awayassignment_i.utils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object {
        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://digi-api.airtel.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient())
                .build()
        }
        fun getApiService() = getInstance().create(ApiClient::class.java)
    }



}