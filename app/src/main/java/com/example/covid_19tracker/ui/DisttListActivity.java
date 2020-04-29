package com.example.covid_19tracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.example.covid_19tracker.Adapter.DisttAdapter;
import com.example.covid_19tracker.Model.DisttModel;
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

public class DisttListActivity extends AppCompatActivity {

    private  int positionCountry;
    private String code;
    RecyclerView dist_recycler;
    String state;
    DisttAdapter disttAdapter;
    EditText edtSearch;
    List<DisttModel.DistrictDatum> temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distt_list);

        dist_recycler = findViewById(R.id.dist_recycler);
        edtSearch = findViewById(R.id.edtSearch);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        dist_recycler.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        state  = intent.getStringExtra("state");

        code = intent.getStringExtra("code");
        Log.i("sjdfbjsdd", "onCreate: "+code);

        getDistt();

       /* edtSearch.addTextChangedListener(new TextWatcher() {
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
        });*/
    }

    /*private void filter(String text){

        ArrayList<DisttModel.DistrictDatum> filterdNames = new ArrayList<>(); //new

        for (DisttModel.DistrictDatum s : temp) {

            if (s.getDistrict().toLowerCase().contains(text.toLowerCase())) {

                filterdNames.add(s);
            }
        }
        disttAdapter.filterList(filterdNames);
    }
*/
    void getDistt(){

        RetrofitClint.getStateRetrofit(Constant.STATES_URL)
                .create(GetRequest.class)
                .getDistAffacted()
                .enqueue(new Callback<List<DisttModel>>() {
                    @Override
                    public void onResponse(Call<List<DisttModel>> call, Response<List<DisttModel>> response) {
                        Log.i("mdnbsdjvkfd", "onResponse: "+response);
                        Log.i("mdnbsdjvkfd", "onResponse: "+response.body());


                        for(int i = 0 ; i < response.body().size() ; i++ ){
                            if(response.body().get(i).getStatecode().equals(code)){
                                positionCountry = i;
                                break;
                            }
                        }

                       /* temp  = new ArrayList<>();
                        for(int j = 0 ; j< response.body().get(positionCountry).getDistrictData().size();j++){
                            DisttModel.DistrictDatum model = response.body().get(positionCountry).getDistrictData().get(j);
                            model.setId(j);
                            temp.add(model);
                        }*/

                             disttAdapter = new DisttAdapter(DisttListActivity.this,response.body().get(positionCountry).getDistrictData(),code);
                            dist_recycler.setAdapter(disttAdapter);

                    }

                    @Override
                    public void onFailure(Call<List<DisttModel>> call, Throwable t) {

                    }
                });
    }
}
