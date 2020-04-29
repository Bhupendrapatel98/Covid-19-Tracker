package com.example.covid_19tracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.covid_19tracker.Adapter.DisttAdapter;
import com.example.covid_19tracker.Model.DisttModel;
import com.example.covid_19tracker.R;
import com.example.covid_19tracker.network.Constant;
import com.example.covid_19tracker.network.GetRequest;
import com.example.covid_19tracker.network.RetrofitClint;
import com.leo.simplearcloader.SimpleArcLoader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisttDetailActivity extends AppCompatActivity {

    private  int positionCountry;
    private int position;
    private String code;
    TextView tvdist_data,tvdist_Cases,tvdistTodayCases,tvdistDeaths,tvdistTodayDeaths,tvdistRecovered,tvdistActive,tvdistCritical;
    SimpleArcLoader simpleArcLoader;
    CardView distt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distt_detail);

        Intent intent = getIntent();
        code = intent.getStringExtra("code");
        Log.i("kdjkjfkd", "onCreate1: "+code);

        Intent intent1 = getIntent();
        position = intent1.getIntExtra("position",0);

        distt = findViewById(R.id.distt);

        tvdist_data = findViewById(R.id.tvdist_data);
        tvdist_Cases = findViewById(R.id.tvdist_Cases);
        tvdistTodayCases = findViewById(R.id.tvdistTodayCases);
        tvdistDeaths = findViewById(R.id.tvdistDeaths);
        tvdistTodayDeaths = findViewById(R.id.tvdistTodayDeaths);
        tvdistRecovered = findViewById(R.id.tvdistRecovered);
        tvdistActive = findViewById(R.id.tvdistActive);
        tvdistCritical = findViewById(R.id.tvdistCritical);

        simpleArcLoader = findViewById(R.id.loader);

        getDisttDetail();

    }

    void getDisttDetail(){

        RetrofitClint.getStateRetrofit(Constant.STATES_URL)
                .create(GetRequest.class)
                .getDistAffacted()
                .enqueue(new Callback<List<DisttModel>>() {
                    @Override
                    public void onResponse(Call<List<DisttModel>> call, Response<List<DisttModel>> response) {
                        Log.i("mdnbsdjvkfd", "onResponse: "+response);
                        Log.i("mdnbsdjvkfd", "onResponse: "+response.body());

                        simpleArcLoader.stop();
                        simpleArcLoader.setVisibility(View.GONE);
                        distt.setVisibility(View.VISIBLE);

                        for(int i = 0 ; i < response.body().size() ; i++ ){
                            if(response.body().get(i).getStatecode().equals(code)){
                                positionCountry = i;
                                break;
                            }
                        }

                        String title = response.body().get(positionCountry).getDistrictData().get(position).getDistrict();
                        getSupportActionBar().setTitle("Details of "+title);
                        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                        getSupportActionBar().setDisplayShowHomeEnabled(true);

                        Log.i("kdjkjfkd", "onResponse2: "+positionCountry);

                        Log.i("jdfndkjdfk", "onResponse: "+response.body().get(positionCountry).getDistrictData().get(position).getDistrict());

                        tvdist_data.setText(response.body().get(positionCountry).getDistrictData().get(position).getDistrict());
                        tvdist_Cases.setText(""+response.body().get(positionCountry).getDistrictData().get(position).getConfirmed());
                        tvdistRecovered.setText(""+response.body().get(positionCountry).getDistrictData().get(position).getRecovered());
                        tvdistActive.setText(""+response.body().get(positionCountry).getDistrictData().get(position).getActive());
                        tvdistDeaths.setText(""+response.body().get(positionCountry).getDistrictData().get(position).getDeceased());
                        tvdistTodayCases.setText(""+response.body().get(positionCountry).getDistrictData().get(position).getDelta().getConfirmed());
                        tvdistTodayDeaths.setText(""+response.body().get(positionCountry).getDistrictData().get(position).getDelta().getDeceased());



                    }

                    @Override
                    public void onFailure(Call<List<DisttModel>> call, Throwable t) {

                    }
                });
    }
}
