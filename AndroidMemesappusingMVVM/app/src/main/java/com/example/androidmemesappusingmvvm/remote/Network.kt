package com.example.androidmemesappusingmvvm.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Network {
   fun getRetrofit():Retrofit{
       return Retrofit.Builder()
           .baseUrl("https://api.imgflip.com/")
           .addConverterFactory(GsonConverterFactory.create())
           .client(OkHttpClient())
           .build()
   }

}
