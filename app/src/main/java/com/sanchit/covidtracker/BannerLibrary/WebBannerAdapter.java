package com.sanchit.covidtracker.BannerLibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.databinding.SingleUpdateLayoutBinding;
import com.sanchit.covidtracker.response.UpdatesResponse;

import java.util.List;

import retrofit2.Callback;

public class WebBannerAdapter extends RecyclerView.Adapter<WebBannerAdapter.MzViewHolder> {

    private Context context;
    private List<String> urlList;
    List<UpdatesResponse> updateList;
    private BannerLayout.OnBannerItemClickListener onBannerItemClickListener;

   /* public WebBannerAdapter(Context context, List<String> urlList) {
        this.context = context;
        this.urlList = urlList;
    }*/

    public WebBannerAdapter(Context context, List<UpdatesResponse> updateList) {
        this.context = context;
        this.updateList=updateList;
    }

    @NonNull
    @Override
    public WebBannerAdapter.MzViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


      //  SingleUpdateLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.single_update_layout,parent,false);
        return new MzViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_update_layout, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull WebBannerAdapter.MzViewHolder holder, int position) {


        holder.tvUpdate.setText(updateList.get(position).getUpdate());
        holder.timeago.setText(String.valueOf(updateList.get(position).getTimestamp()));
       /* if (urlList == null || urlList.isEmpty())
            return;
        final int P = position % urlList.size();
        String url = urlList.get(P);
        ImageView img = (ImageView) holder.imageView;
        Glide.with(context).load(url).into(img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onBannerItemClickListener != null) {
                    onBannerItemClickListener.onItemClick(P);
                }

            }
        });
*/
    }

    @Override
    public int getItemCount() {
        if (updateList != null) {
            return updateList.size();
        }
        return 0;
    }

    public class MzViewHolder extends RecyclerView.ViewHolder {
      //  ImageView imageView;

        TextView tvUpdate,timeago;
        public MzViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUpdate = (TextView) itemView.findViewById(R.id.tv_update);
            timeago = (TextView) itemView.findViewById(R.id.tv_time_ago);
          //  imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
