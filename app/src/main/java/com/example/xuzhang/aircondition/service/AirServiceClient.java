package com.example.xuzhang.aircondition.service;

import com.example.xuzhang.aircondition.domain.PM25;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class AirServiceClient {
    private static AirServiceClient instance = null;
    private final AirService airService;

    private AirServiceClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.pm25.in").
                addConverterFactory(GsonConverterFactory.create()).build();
        airService = retrofit.create(AirService.class);
    }

    public static AirServiceClient getInstance() {
        if(instance == null) {
            instance = new AirServiceClient();
        }
        return instance;
    }

    public void queryAirConditionData(Callback<List<PM25>> callback) {
        Call<List<PM25>> call = airService.getPM25Info("西安", "4esfG6UEhGzNkbszfjAp");
        call.enqueue(callback);
    }
}
