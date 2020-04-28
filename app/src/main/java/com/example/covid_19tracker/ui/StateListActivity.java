package com.example.covid_19tracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.covid_19tracker.Adapter.StateAdapter;
import com.example.covid_19tracker.Model.StateModel;
import com.example.covid_19tracker.R;
import com.example.covid_19tracker.network.Constant;
import com.example.covid_19tracker.network.GetRequest;
import com.example.covid_19tracker.network.RetrofitClint;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StateListActivity extends AppCompatActivity {

    RecyclerView state_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_detail);

        state_recycler = findViewById(R.id.state_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        state_recycler.setLayoutManager(layoutManager);

        getStates();

    }

    void getStates(){

        RetrofitClint.getStateRetrofit(Constant.STATES_URL)
                .create(GetRequest.class)
                .getStateAffacted()
                .enqueue(new Callback<StateModel>() {
                    @Override
                    public void onResponse(Call<StateModel> call, Response<StateModel> response) {

                        Log.i("mdsbjbksdjfksd", "onResponse: "+response);
                        Log.i("mdsbjbksdjfksd", "onResponse: "+response.body());

                        StateAdapter adapter = new StateAdapter(getApplicationContext(),response.body().getStatewise());
                        state_recycler.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<StateModel> call, Throwable t) {

                    }
                });
    }
}
