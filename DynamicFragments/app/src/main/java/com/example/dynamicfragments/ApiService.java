package com.example.dynamicfragments;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("{userName}/{userId}/{raw}/{userBrokenId}/{brokenName}")
    Call<ArrayList<ResponseDTO>> getData(@Path("userName") String userName,
                                         @Path("userId") String userId,
                                         @Path("raw") String raw,
                                         @Path("userBrokenId") String userBrokenId,
                                         @Path("brokenName") String brokenName);
}
