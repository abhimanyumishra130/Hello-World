package com.example.and03unit_2c_2;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("v1/us/daily.json")
    Call<List<ResponseModel>> getPost();
}
