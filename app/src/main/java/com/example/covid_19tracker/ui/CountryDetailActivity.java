package com.example.covid_19tracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.covid_19tracker.Model.CountryModel;
import com.example.covid_19tracker.R;
import com.example.covid_19tracker.network.Constant;
import com.example.covid_19tracker.network.GetRequest;
import com.example.covid_19tracker.network.RetrofitClint;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryDetailActivity extends AppCompatActivity {

    private  int positionCountry;
    TextView tvCountry,tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);

        //ArrayList<CountryModel> country = (ArrayList<CountryModel>) getIntent().getSerializableExtra("country");
        //Log.i("cghsdg", "onCreate: "+ country);

        /*getSupportActionBar().setTitle("Details of "+country.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);*/

        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);

        getData();
    }

    void getData(){

        RetrofitClint.getRetrofit(Constant.BASE_URL)
                .create(GetRequest.class)
                .getContryAffacted()
                .enqueue(new Callback<List<CountryModel>>() {
                    @Override
                    public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {
                        Log.i("mdbcsdjksd", "onResponse: "+response);
                        Log.i("mdbcsdjksd", "onResponse: "+response.body());
                        Log.i("mdbcsdjksd", "onResponse: "+response.body().get(positionCountry).getCountryInfo().getFlag());
                        Log.i("mdbcsdjksd", "onResponse: "+response.body().get(positionCountry).getCountry());


                        tvCountry.setText(response.body().get(positionCountry).getCountry());
                        tvCases.setText(response.body().get(positionCountry).getCases());
                        tvRecovered.setText(response.body().get(positionCountry).getRecovered());
                        tvCritical.setText(response.body().get(positionCountry).getCritical());
                        tvActive.setText(response.body().get(positionCountry).getActive());
                        tvTodayCases.setText(response.body().get(positionCountry).getTodayCases());
                        tvTotalDeaths.setText(response.body().get(positionCountry).getDeaths());
                        tvTodayDeaths.setText(response.body().get(positionCountry).getTodayDeaths());

                    }

                    @Override
                    public void onFailure(Call<List<CountryModel>> call, Throwable t) {

                        Log.i("mdhcbsjd", "onFailure: "+t);
                    }
                });
    }
}
