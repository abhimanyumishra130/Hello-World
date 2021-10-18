package com.example.roomdatabasemoneymanagerapp.Retrofit.requests

import com.google.gson.annotations.SerializedName

data class LoginRequestModel(@SerializedName("email") val userName: String,
                             @SerializedName("password") val password: String)