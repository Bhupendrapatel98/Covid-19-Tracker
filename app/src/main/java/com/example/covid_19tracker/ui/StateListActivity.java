package com.example.covid_19tracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.example.covid_19tracker.Adapter.StateAdapter;
import com.example.covid_19tracker.Model.CountryModel;
import com.example.covid_19tracker.Model.StateModel;
import com.example.covid_19tracker.R;
import com.example.covid_19tracker.network.Constant;
import com.example.covid_19tracker.network.GetRequest;
import com.example.covid_19tracker.network.RetrofitClint;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StateListActivity extends AppCompatActivity {

    EditText edtSearch;
    RecyclerView state_recycler;
    StateAdapter adapter;
    List<StateModel.Statewise> temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_detail);

        state_recycler = findViewById(R.id.state_recycler);
        edtSearch = findViewById(R.id.edtSearch);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        state_recycler.setLayoutManager(layoutManager);

        getStates();

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString());
            }
        });

    }

    private void filter(String text){

        ArrayList<StateModel.Statewise> filterdNames = new ArrayList<>(); //new

        for (StateModel.Statewise s : temp) {

            if (s.getState().toLowerCase().contains(text.toLowerCase())) {

                filterdNames.add(s);
            }
        }
        adapter.filterList(filterdNames);
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

                        response.body().getStatewise().remove(0);

                        temp  = new ArrayList<>();
                        for(int i = 0 ; i< response.body().getStatewise().size();i++){

                            StateModel.Statewise model = response.body().getStatewise().get(i);
                            model.setId(i);
                            temp.add(model);
                        }

                         adapter = new StateAdapter(getApplicationContext(),response.body().getStatewise());
                        state_recycler.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<StateModel> call, Throwable t) {

                    }
                });
    }

}
