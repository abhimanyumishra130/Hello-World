package com.example.getlistofalbums;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("albums")
    Call<ArrayList<ResponseDTO>> getData();
}
