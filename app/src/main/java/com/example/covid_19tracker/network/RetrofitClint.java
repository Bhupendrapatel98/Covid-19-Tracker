package com.example.covid_19tracker.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClint {

    private static Retrofit retrofit;
    private static Retrofit retrofitstate;

    public static Retrofit getRetrofit(String s) {
        if (retrofit==null)
            return retrofit = new Retrofit.Builder()
                    .baseUrl(s)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        else
        return retrofit;
    }

    public static Retrofit getStateRetrofit(String st) {
        if (retrofitstate==null)
            return retrofitstate = new Retrofit.Builder()
                    .baseUrl(st)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        else
            return retrofitstate;
    }
}
