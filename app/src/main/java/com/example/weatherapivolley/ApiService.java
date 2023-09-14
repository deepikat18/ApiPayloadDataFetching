package com.example.weatherapivolley;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("MobileLogin")
    Call<ResponseModel> authenticate(@Body LoginRequest loginRequest);
}

