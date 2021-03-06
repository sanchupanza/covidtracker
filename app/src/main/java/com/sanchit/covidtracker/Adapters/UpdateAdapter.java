package com.sanchit.covidtracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.Utils.Constants;
import com.sanchit.covidtracker.databinding.SingleUpdateItemLayoutBinding;
import com.sanchit.covidtracker.databinding.SingleUpdateLayoutBinding;
import com.sanchit.covidtracker.response.UpdatesResponse;

import java.util.List;

public class UpdateAdapter extends RecyclerView.Adapter<UpdateAdapter.MyViewHolder> {

    private List<UpdatesResponse> list;
    private Context context;

    public UpdateAdapter(List<UpdatesResponse> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public UpdateAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleUpdateItemLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.single_update_item_layout,parent,false);
        return new UpdateAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UpdateAdapter.MyViewHolder holder, int position) {
        holder.binding.tvUpdate.setText(list.get(position).getUpdate());

        holder.binding.tvTimeAgo.setText(Constants.getTimesAgo(String.valueOf(list.get(position).getTimestamp())));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SingleUpdateItemLayoutBinding binding;
        public MyViewHolder(@NonNull SingleUpdateItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }
}
