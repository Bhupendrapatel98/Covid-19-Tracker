package com.example.covid_19tracker.network;

import com.example.covid_19tracker.Model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetRequest {

    @GET("all")
    Call<DataModel> getData();

    @GET("countries")
    Call<DataModel> getContry();


}
