package com.example.retrofit1;

import android.graphics.ColorSpace;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/api/users/{userId}")             //get and path user id name should be same
    Call<ResponseModel> getUser(@Path("userId") int userId);

}
