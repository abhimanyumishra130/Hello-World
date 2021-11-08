package com.example.w45_codingevalutation.Data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object{
         fun getInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient())
                .build()
        }
    }
}