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

import com.example.covid_19tracker.Model.StateModel;
import com.example.covid_19tracker.R;
import com.example.covid_19tracker.ui.StateDataActivity;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateViewHolder> {

    private Context context;
    private List<StateModel.Statewise> stateModelsList;

    public StateAdapter(Context context, List<StateModel.Statewise> stateModelsList) {
        this.context = context;
        this.stateModelsList = stateModelsList;
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.state_list_item,parent,false);
        return new StateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateViewHolder holder, int position) {


        holder.tvstateName.setText(stateModelsList.get(position).getState());

        int pos = holder.getAdapterPosition();
        Log.i("djfsdkjfdkf", "onBindViewHolder: "+pos);

        holder.state_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(context, StateDataActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               //intent.putExtra("country",(ArrayList<CountryModel>)(countryModelsList));
                intent.putExtra("position",pos);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stateModelsList.size();
    }

    public class StateViewHolder extends RecyclerView.ViewHolder {

        TextView tvstateName;
        CardView state_main;

        public StateViewHolder(@NonNull View itemView) {
            super(itemView);
            tvstateName = itemView.findViewById(R.id.tvstateName);
            state_main = itemView.findViewById(R.id.state_main);
        }
    }
}
