package com.sanchit.covidtracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.databinding.SingleCountryLayoutBinding;
import com.sanchit.covidtracker.response.WorldSummary.Country;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    private Context context;
    private List<Country> list;
    public CountryAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.list = countryList;
    }

    @NonNull
    @Override
    public CountryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleCountryLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.single_country_layout,parent,false);


        return new CountryAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.MyViewHolder holder, int position) {

        Country current = list.get(position);

        holder.binding.tvConfirm.setText(String.valueOf(current.getTotalConfirmed()));
        holder.binding.tvRecovered.setText(String.valueOf(current.getTotalRecovered()));
        holder.binding.tvDeath.setText(String.valueOf(current.getTotalDeaths()));

        holder.binding.tvStateName.setText(current.getCountry());

        if(current.getNewConfirmed() !=0)
        {
            holder.binding.tvCNew.setText("+"+ current.getNewConfirmed());
        }else
        {
            holder.binding.tvCNew.setVisibility(View.GONE);
        }
        if(current.getNewRecovered() !=0)
        {
            holder.binding.tvRNew.setText("+"+current.getNewRecovered());
        }else {
            holder.binding.tvRNew.setVisibility(View.GONE);
        }
        if(current.getTotalDeaths() !=0)
        {
            holder.binding.tvDNew.setText("+"+current.getNewDeaths());
        }else {
            holder.binding.tvDNew.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        SingleCountryLayoutBinding binding;


        public MyViewHolder(@NonNull SingleCountryLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
