package com.sanchit.covidtracker.Activities.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.databinding.SingleDatesLayoutBinding;
import com.sanchit.covidtracker.response.AllData.CasesTimeSeries;
import com.sanchit.covidtracker.response.AllData.DataResponse;

import java.util.List;

import retrofit2.Callback;

public class DateWiseAdapter extends RecyclerView.Adapter<DateWiseAdapter.MyViewHolder> {
    private  List<CasesTimeSeries> list;
    private Context context;
    private OnDateClickListener listener;

    public DateWiseAdapter(List<CasesTimeSeries> casesTimeSeries, Context context) {
        this.list = casesTimeSeries;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public DateWiseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleDatesLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.single_dates_layout,parent,false);

        return new DateWiseAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DateWiseAdapter.MyViewHolder holder, int position) {


        if(position==0||position==1)
        {
            holder.binding.layout.setBackgroundResource(R.drawable.date_bg_solid);
            holder.binding.tvCount.setTextColor(Color.parseColor("#D24C7E"));
            holder.binding.tvDate.setTextColor(Color.parseColor("#D24C7E"));

        }
        holder.binding.tvCount.setText(String.valueOf(list.get(position).getDailyconfirmed()));
        holder.binding.tvDate.setText(list.get(position).getDate());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((OnDateClickListener)context).onDateClick(position);
            }
        });
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
    public interface OnDateClickListener
    {
        void onDateClick(int position);
    }
}
