package covid.tracker.covid_19tracker.network;

import covid.tracker.covid_19tracker.Model.CountryModel;
import covid.tracker.covid_19tracker.Model.DataModel;
import covid.tracker.covid_19tracker.Model.DisttModel;
import covid.tracker.covid_19tracker.Model.StateModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetRequest {

    @GET("all")
    Call<DataModel> getData();

    @GET("countries")
    Call<List<CountryModel>> getContryAffacted();

    @GET("data.json")
    Call<StateModel> getStateAffacted();

    @GET("v2/state_district_wise.json")
    Call<List<DisttModel>> getDistAffacted();
}
