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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.covid_19tracker.Model.CountryModel;
import com.example.covid_19tracker.R;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private Context context;
    private List<CountryModel> countryModelsList;

    public CountryAdapter(Context context, List<CountryModel> countryModelsList) {
        this.context = context;
        this.countryModelsList = countryModelsList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.list_item,parent,false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {

        holder.tvCountryName.setText(countryModelsList.get(position).getCountry());
        Glide.with(context).load(countryModelsList.get(position).getCountryInfo().getFlag()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return countryModelsList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView tvCountryName;
        ImageView imageView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountryName = itemView.findViewById(R.id.tvCountryName);
            imageView = itemView.findViewById(R.id.imageFlag);
        }
    }
}
