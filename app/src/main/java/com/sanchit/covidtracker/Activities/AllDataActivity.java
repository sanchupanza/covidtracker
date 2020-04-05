package com.sanchit.covidtracker.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.adapters.AbsListViewBindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.Toast;

import com.sanchit.covidtracker.Activities.Adapters.DateWiseAdapter;
import com.sanchit.covidtracker.Activities.Adapters.StatewiseDataAdapter;
import com.sanchit.covidtracker.Network.SoleInstance;
import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.databinding.ActivityAllDataBinding;
import com.sanchit.covidtracker.databinding.ActivityAllDataNewBinding;
import com.sanchit.covidtracker.databinding.ActivityAllDataNewDesignBinding;
import com.sanchit.covidtracker.response.AllData.CasesTimeSeries;
import com.sanchit.covidtracker.response.AllData.DataResponse;
import com.sanchit.covidtracker.response.AllData.Statewise;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllDataActivity extends AppCompatActivity   {


    private ActivityAllDataNewDesignBinding binding;
    private Context context;
    private StatewiseDataAdapter adapter;
    private DateWiseAdapter dateWiseAdapter;
    Animation rotateAnimation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_all_data_new_design);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        context = this;
     //   binding.rvStatewise.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        fetchAllData();
        animation();


        binding.marqueeText.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        binding.marqueeText.setText("General Information... general information... General Information");
        binding.marqueeText.setSelected(true);
        binding.marqueeText.setSingleLine(true);





    }


    private void animation()
    {
        rotateAnimation= AnimationUtils.loadAnimation(this,R.anim.rotate);
        binding.image1.startAnimation(rotateAnimation);

        rotateAnimation= AnimationUtils.loadAnimation(this,R.anim.reverse_rotate);
        binding.image2.startAnimation(rotateAnimation);

        rotateAnimation= AnimationUtils.loadAnimation(this,R.anim.reverse_rotate);
        binding.image3.startAnimation(rotateAnimation);

        rotateAnimation= AnimationUtils.loadAnimation(this,R.anim.reverse_rotate);
        binding.image4.startAnimation(rotateAnimation);



    }

    private void fetchAllData() {
        Call<DataResponse> call = SoleInstance.getApiServiceInstance().getAllData();

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {

                if(response !=null)
                {
                    if(response.body() !=null)
                    {
                        binding.tvCCount.setText(String.valueOf(response.body().getStatewise().get(0).getConfirmed()));
                        binding.tvACount.setText(String.valueOf(response.body().getStatewise().get(0).getActive()));
                        binding.tvRCount.setText(String.valueOf(response.body().getStatewise().get(0).getRecovered()));
                        binding.tvDCount.setText(String.valueOf(response.body().getStatewise().get(0).getDeaths()));


                        binding.tvCDelCount.setText("+"+response.body().getStatewise().get(0).getDeltaconfirmed());
                   //     binding.tvADelCount.setText("[+"+ response.body().getStatewise().get(0).getDelta().getActive() +"]");
                        binding.tvRDelCount.setText("+"+response.body().getStatewise().get(0).getDeltarecovered());
                        binding.tvDDelCount.setText("+"+response.body().getStatewise().get(0).getDeltadeaths());

                        adapter = new StatewiseDataAdapter(response.body().getStatewise(),context);
                    //    binding.rvStatewise.setAdapter(adapter);
                        List<CasesTimeSeries> list = response.body().getCasesTimeSeries();
                        Collections.reverse(list);
                        dateWiseAdapter = new DateWiseAdapter(list,context);
                        binding.recyclerView.setAdapter(dateWiseAdapter);
                        binding.recyclerView.setItemViewCacheSize(list.size());
                       // binding.recyclerView.scrollToPosition((response.body().getCasesTimeSeries().size()-1));





                    }else
                    {
                        Toast.makeText(AllDataActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(AllDataActivity.this, "No response", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void sendDatatoStateWiseAdapter(List<Statewise> statewise) {

    }


}
