package com.example.covid_19tracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.admin.NetworkEvent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.example.covid_19tracker.Model.DataModel;
import com.example.covid_19tracker.R;

import com.example.covid_19tracker.network.Constant;
import com.example.covid_19tracker.network.GetRequest;
import com.example.covid_19tracker.network.RetrofitClint;
import com.google.android.material.snackbar.Snackbar;
import com.leo.simplearcloader.SimpleArcLoader;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.DialogPlusBuilder;
import com.orhanobut.dialogplus.ViewHolder;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.Gravity.CENTER;

public class MainActivity extends AppCompatActivity {

    TextView tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths,tvAffectedCountries;
    SimpleArcLoader simpleArcLoader;
    ScrollView scrollView;
    PieChart pieChart;
    Button btnTrack,refresh;
    LinearLayout nointernet;
    RelativeLayout internet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refresh = findViewById(R.id.refresh);
        nointernet = findViewById(R.id.nointernet);
        internet = findViewById(R.id.internet);

        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvAffectedCountries = findViewById(R.id.tvAffectedCountries);
        simpleArcLoader = findViewById(R.id.loader);
        scrollView = findViewById(R.id.scrollStats);
        pieChart = findViewById(R.id.piechart);
        btnTrack = findViewById(R.id.btnTrack);

                if (isNetworkConnected()){
                    internet.setVisibility(View.VISIBLE);
                    getAllDAta();
                }
                else {
                    nointernet.setVisibility(View.VISIBLE);
                    
                    refresh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (isNetworkConnected()){
                                nointernet.setVisibility(View.GONE);
                                internet.setVisibility(View.VISIBLE);
                                getAllDAta();
                            }
                            else {
                                Toast.makeText(MainActivity.this, "please turn on your internet connection", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

        btnTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trackCountries();
            }
        });
    }

    void getAllDAta(){

       simpleArcLoader.start();

        RetrofitClint.getRetrofit(Constant.BASE_URL)
                .create(GetRequest.class)
                .getData()
                .enqueue(new Callback<DataModel>() {
                    @Override
                    public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                        Log.i("smdfbjdshfj", "onResponse: "+response);
                        Log.i("smdfbjdshfj", "onResponse: "+response.body());

                        simpleArcLoader.stop();
                        simpleArcLoader.setVisibility(View.GONE);
                        scrollView.setVisibility(View.VISIBLE);

                        tvCases.setText(""+response.body().getCases());
                        tvRecovered.setText(""+response.body().getRecovered());
                        tvCritical.setText(""+response.body().getCritical());
                        tvActive.setText(""+response.body().getActive());
                        tvTodayCases.setText(""+response.body().getTodayCases());
                        tvTotalDeaths.setText(""+response.body().getDeaths());
                        tvTodayDeaths.setText(""+response.body().getTodayDeaths());
                        tvAffectedCountries.setText(""+response.body().getAffectedCountries());

                        pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#FFA726")));
                        pieChart.addPieSlice(new PieModel("Recoverd",Integer.parseInt(tvRecovered.getText().toString()), Color.parseColor("#66BB6A")));
                        pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(tvTotalDeaths.getText().toString()), Color.parseColor("#EF5350")));
                        pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(tvActive.getText().toString()), Color.parseColor("#29B6F6")));
                        pieChart.startAnimation();
                    }

                    @Override
                    public void onFailure(Call<DataModel> call, Throwable t) {

                    }
                });

    }

   void trackCountries(){
    startActivity(new Intent(MainActivity.this, AffectedCountriesActivity.class));
   }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}
