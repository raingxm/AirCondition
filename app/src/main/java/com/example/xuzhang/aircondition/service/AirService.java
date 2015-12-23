package com.example.xuzhang.aircondition.service;

import com.example.xuzhang.aircondition.domain.PM25;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface AirService {
    @GET("/api/querys/aqi_details.json")
    Call<List<PM25>> getPM25Info(@Query("city") String cityName, @Query("token") String token);
}
