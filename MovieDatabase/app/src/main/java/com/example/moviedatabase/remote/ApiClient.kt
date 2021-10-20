package com.example.moviedatabase.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    companion object{
        val BASE_URL = "https://api.themoviedb.org/3/"
    }
    @GET("movie/popular")
    suspend fun getData(@Query("api_key") api_key:String):ResponseModel
}