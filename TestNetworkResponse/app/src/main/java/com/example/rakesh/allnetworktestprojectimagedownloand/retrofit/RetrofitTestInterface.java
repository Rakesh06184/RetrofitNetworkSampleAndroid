package com.example.rakesh.allnetworktestprojectimagedownloand.retrofit;


import com.example.rakesh.allnetworktestprojectimagedownloand.dto.volley.dto.VolleyImageResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitTestInterface {

    @GET("/json/glide.json")

    Call<List<VolleyImageResponse>> getImageResponse();
}
