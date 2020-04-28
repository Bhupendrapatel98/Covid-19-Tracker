package com.example.covid_19tracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.covid_19tracker.Model.StateModel;
import com.example.covid_19tracker.R;
import com.example.covid_19tracker.network.Constant;
import com.example.covid_19tracker.network.GetRequest;
import com.example.covid_19tracker.network.RetrofitClint;
import com.leo.simplearcloader.SimpleArcLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StateDataActivity extends AppCompatActivity {

    private  int positionCountry;
    private String code;
    TextView tvstate_data,tvstate_Cases,tvstateRecovered,tvstateCritical,tvstateActive,tvstateTodayCases,tvstateDeaths,tvstateTodayDeaths;
    SimpleArcLoader simpleArcLoader;
    CardView state_data;
    Button btnTrackdist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dist_list);

        Intent intent = getIntent();

        code = intent.getStringExtra("code");

        btnTrackdist = findViewById(R.id.btnTrackdist);
        state_data = findViewById(R.id.state_data);
        simpleArcLoader = findViewById(R.id.loader);
        tvstate_data = findViewById(R.id.tvstate_data);
        tvstate_Cases = findViewById(R.id.tvstate_Cases);
        tvstateRecovered = findViewById(R.id.tvstateRecovered);
        tvstateCritical = findViewById(R.id.tvstateCritical);
        tvstateActive = findViewById(R.id.tvstateActive);
        tvstateTodayCases = findViewById(R.id.tvstateTodayCases);
        tvstateDeaths = findViewById(R.id.tvstateDeaths);
        tvstateTodayDeaths = findViewById(R.id.tvstateTodayDeaths);

        getStateData();
    }

    void getStateData(){

        simpleArcLoader.start();

        RetrofitClint.getStateRetrofit(Constant.STATES_URL)
                .create(GetRequest.class)
                .getStateAffacted()
                .enqueue(new Callback<StateModel>() {
                    @Override
                    public void onResponse(Call<StateModel> call, Response<StateModel> response) {

                        Log.i("mdsbjbksdjfksd", "onResponse: "+response);
                        Log.i("mdsbjbksdjfksd", "onResponse: "+response.body());

                        for(int i = 0 ; i < response.body().getStatewise().size() ; i++){
                            if(response.body().getStatewise().get(i).getStatecode().equals(code)){
                                positionCountry = i;
                                break;
                            }
                        }




                        simpleArcLoader.stop();
                        simpleArcLoader.setVisibility(View.GONE);
                        state_data.setVisibility(View.VISIBLE);
                        btnTrackdist.setVisibility(View.VISIBLE);

                        String title = response.body().getStatewise().get(positionCountry).getState();
                        getSupportActionBar().setTitle("Details of "+title);
                        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                        getSupportActionBar().setDisplayShowHomeEnabled(true);


                        tvstate_data.setText(response.body().getStatewise().get(positionCountry).getState());
                        tvstate_Cases.setText(response.body().getStatewise().get(positionCountry).getConfirmed());
                        tvstateRecovered.setText(response.body().getStatewise().get(positionCountry).getRecovered());
                        tvstateActive.setText(response.body().getStatewise().get(positionCountry).getActive());
                        tvstateTodayCases.setText(response.body().getStatewise().get(positionCountry).getDeltaconfirmed());
                        tvstateDeaths.setText(response.body().getStatewise().get(positionCountry).getDeaths());
                        tvstateTodayDeaths.setText(response.body().getStatewise().get(positionCountry).getDeltadeaths());

                        btnTrackdist.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(StateDataActivity.this, DisttListActivity.class);
                                intent.putExtra("code",response.body().getStatewise().get(positionCountry).getStatecode());
                                intent.putExtra("position",positionCountry);
                                startActivity(intent);
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<StateModel> call, Throwable t) {

                    }
                });
    }
}
