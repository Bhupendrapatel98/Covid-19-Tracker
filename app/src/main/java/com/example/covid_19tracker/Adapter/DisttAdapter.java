package com.example.covid_19tracker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19tracker.Model.DisttModel;
import com.example.covid_19tracker.Model.StateModel;
import com.example.covid_19tracker.R;
import com.example.covid_19tracker.ui.DisttDetailActivity;
import com.example.covid_19tracker.ui.StateDataActivity;

import java.util.List;

public class DisttAdapter extends RecyclerView.Adapter<DisttAdapter.DistViewHolder> {

    private Context context;
    private List<DisttModel.DistrictDatum> distModelsList;
    private String code;

    public DisttAdapter(Context context, List<DisttModel.DistrictDatum> distModelsList,String code) {
        this.context = context;
        this.distModelsList = distModelsList;
        this.code=code;
    }

    @NonNull
    @Override
    public DistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.state_list_item,parent,false);
        return new DistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DistViewHolder holder, int position) {


        holder.tvstateName.setText(distModelsList.get(position).getDistrict());

        int pos = holder.getAdapterPosition();
        Log.i("djfsdkjfdkf", "onBindViewHolder: "+pos);

       holder.state_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(context, DisttDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               //intent.putExtra("country",(ArrayList<CountryModel>)(countryModelsList));
                intent.putExtra("position",pos);
                intent.putExtra("code",code);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return distModelsList.size();
    }

    public class DistViewHolder extends RecyclerView.ViewHolder {

        TextView tvstateName;
        CardView state_main;

        public DistViewHolder(@NonNull View itemView) {
            super(itemView);
            tvstateName = itemView.findViewById(R.id.tvstateName);
            state_main = itemView.findViewById(R.id.state_main);
        }
    }
}
