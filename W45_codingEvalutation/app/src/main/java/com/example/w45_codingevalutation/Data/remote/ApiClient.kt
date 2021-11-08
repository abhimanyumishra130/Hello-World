package com.example.w45_codingevalutation.Data.remote

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import java.util.*

interface ApiClient {

    @GET("everything?q=latest breaking news&sortBy=publishedAt&apiKey=2890a5db9eb84ba09f6880b22c992edc")
    fun getData():Observable<ResponseModel>
}