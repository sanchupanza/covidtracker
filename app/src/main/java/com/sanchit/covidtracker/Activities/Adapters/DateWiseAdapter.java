package com.sanchit.covidtracker.Activities.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.databinding.SingleDatesLayoutBinding;
import com.sanchit.covidtracker.databinding.SingleRowStateBinding;
import com.sanchit.covidtracker.response.AllData.CasesTimeSeries;

import java.util.List;

public class DateWiseAdapter extends RecyclerView.Adapter<DateWiseAdapter.MyViewHolder> {
    private  List<CasesTimeSeries> list;
    private Context context;
    public DateWiseAdapter(List<CasesTimeSeries> casesTimeSeries, Context context) {
        this.list = casesTimeSeries;
        this.context = context;
    }

    @NonNull
    @Override
    public DateWiseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleDatesLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.single_dates_layout,parent,false);

        return new DateWiseAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DateWiseAdapter.MyViewHolder holder, int position) {
        holder.binding.tvCount.setText(String.valueOf(list.get(position).getDailyconfirmed()));
        holder.binding.tvDate.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SingleDatesLayoutBinding binding;
        public MyViewHolder(@NonNull SingleDatesLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
