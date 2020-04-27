package com.example.covid_19tracker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.covid_19tracker.Model.CountryModel;
import com.example.covid_19tracker.R;
import com.example.covid_19tracker.ui.CountryDetailActivity;

import java.util.ArrayList;
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

        int pos = holder.getAdapterPosition();
        Log.i("djfsdkjfdkf", "onBindViewHolder: "+pos);

        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(context, CountryDetailActivity.class);
               //intent.putExtra("country",(ArrayList<CountryModel>)(countryModelsList));
                intent.putExtra("position",pos);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryModelsList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView tvCountryName;
        ImageView imageView;
        LinearLayout main;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountryName = itemView.findViewById(R.id.tvCountryName);
            imageView = itemView.findViewById(R.id.imageFlag);
            main = itemView.findViewById(R.id.main);
        }
    }
}
