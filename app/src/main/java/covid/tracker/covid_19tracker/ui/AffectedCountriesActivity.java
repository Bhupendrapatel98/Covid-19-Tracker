package covid.tracker.covid_19tracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import covid.tracker.covid_19tracker.Adapter.CountryAdapter;
import covid.tracker.covid_19tracker.Model.CountryModel;

import com.example.covid_19tracker.R;
import covid.tracker.covid_19tracker.network.Constant;
import covid.tracker.covid_19tracker.network.GetRequest;
import covid.tracker.covid_19tracker.network.RetrofitClint;

import com.leo.simplearcloader.SimpleArcLoader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AffectedCountriesActivity extends AppCompatActivity {

    EditText edtSearch;
    RecyclerView recyclerview;
    SimpleArcLoader simpleArcLoader;
    CountryAdapter adapter;
    List<CountryModel> temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affected_countries);


        edtSearch = findViewById(R.id.edtSearch);
        recyclerview = findViewById(R.id.recyclerview);
        simpleArcLoader = findViewById(R.id.loader);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);

        getSupportActionBar().setTitle("Affected Countries");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getData();

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

    private void filter(String text) {

        ArrayList<CountryModel> filterdNames = new ArrayList<>(); //new

        for (CountryModel s : temp) {

            if (s.getCountry().toLowerCase().contains(text.toLowerCase())) {

                filterdNames.add(s);
            }
        }
        adapter.filterList(filterdNames);
    }

    void getData(){

        simpleArcLoader.start();

        RetrofitClint.getRetrofit(Constant.BASE_URL)
                .create(GetRequest.class)
                .getContryAffacted()
                .enqueue(new Callback<List<CountryModel>>() {
                    @Override
                    public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {
                        Log.i("mdbcsdjksd", "onResponse: "+response);
                        Log.i("mdbcsdjksd", "onResponse: "+response.body());
                        Log.i("mdbcsdjksd", "onResponse: "+response.body().get(0).getCountryInfo().getFlag());

                        simpleArcLoader.stop();
                        simpleArcLoader.setVisibility(View.GONE);
                        recyclerview.setVisibility(View.VISIBLE);

                        temp  = new ArrayList<>();

                        for(int i = 0 ; i< response.body().size();i++){
                            CountryModel model = response.body().get(i);
                            model.setId(i);
                            temp.add(model);
                        }


                        adapter = new CountryAdapter(AffectedCountriesActivity.this,response.body());
                        recyclerview.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<CountryModel>> call, Throwable t) {

                        Log.i("mdhcbsjd", "onFailure: "+t);
                    }
                });
    }
}
