package com.example.covid_19tracker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.covid_19tracker.Model.CountryModel;
import com.example.covid_19tracker.R;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<CountryModel> {

    private Context context;
    private List<CountryModel> countryModelsList;

    public CountryAdapter( Context context, List<CountryModel> countryModelsList) {
        super(context, R.layout.list_item,countryModelsList);

        this.context = context;
        this.countryModelsList = countryModelsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,null,true);

        TextView tvCountryName = view.findViewById(R.id.tvCountryName);
        ImageView imageView = view.findViewById(R.id.imageFlag);

        tvCountryName.setText(countryModelsList.get(position).getCountry());
        Glide.with(context).load(countryModelsList.get(position).getCountryInfo().getFlag()).into(imageView);

        return view;
    }

}
