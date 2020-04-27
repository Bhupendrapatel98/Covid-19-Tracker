package com.example.covid_19tracker.network;

import com.example.covid_19tracker.Model.CountryModel;
import com.example.covid_19tracker.Model.DataModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetRequest {

    @GET("all")
    Call<DataModel> getData();

    @GET("countries")
    Call<List<CountryModel>> getContryAffacted();
}
