package com.sanchit.covidtracker.Activities.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.databinding.SingleRowStateBinding;
import com.sanchit.covidtracker.response.AllData.Statewise;

import java.util.List;

public class StatewiseDataAdapter extends RecyclerView.Adapter<StatewiseDataAdapter.MyViewHolder> {

    private List<Statewise> list;
    private Context context;

    public StatewiseDataAdapter(List<Statewise> statewise, Context context) {
        this.list = statewise;
        this.context = context;
    }

    @NonNull
    @Override
    public StatewiseDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleRowStateBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.single_row_state,parent,false);

        return new StatewiseDataAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StatewiseDataAdapter.MyViewHolder holder, int position) {
        if(!list.get(position).getStatecode().equals("TT"))
        {
            holder.binding.tvStateName.setText(list.get(position).getState());
            holder.binding.tvActive.setText(String.valueOf(list.get(position).getActive()));
      //      holder.binding.tvRecovered.setText(String.valueOf(list.get(position).getRecovered()));
       //     holder.binding.tvDeath.setText(String.valueOf(list.get(position).getDeaths()));


            if(list.get(position).getDeltaconfirmed().equals("0"))
            {
                holder.binding.tvConfirm.setText(String.valueOf(list.get(position).getConfirmed()));
            }else
            {
                String delta = "[+"+list.get(position).getDeltaconfirmed()+"]  "+list.get(position).getConfirmed();
                holder.binding.tvConfirm.setText(delta);
            }


            if(list.get(position).getDeltarecovered().equals("0"))
            {
                holder.binding.tvRecovered.setText(String.valueOf(list.get(position).getRecovered()));
            }else
            {
                String delta = "[+"+list.get(position).getDeltarecovered()+"]  "+list.get(position).getRecovered();
                holder.binding.tvRecovered.setText(delta);
            }


            if(list.get(position).getDeltadeaths().equals("0"))
            {
                holder.binding.tvDeath.setText(String.valueOf(list.get(position).getDeaths()));
            }else
            {
                String delta = "[+"+list.get(position).getDeltadeaths()+"]  "+list.get(position).getDeaths();
                holder.binding.tvDeath.setText(delta);
            }






        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        SingleRowStateBinding binding;
        public MyViewHolder(@NonNull SingleRowStateBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
