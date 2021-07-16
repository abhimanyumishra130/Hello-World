package com.example.retrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/Comments")
    Call<List<Responsemodel>> getPost(@Query("postId") int postId);
}
