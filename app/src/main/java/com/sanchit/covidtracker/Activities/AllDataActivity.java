package com.sanchit.covidtracker.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.adapters.AbsListViewBindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.sanchit.covidtracker.Activities.Adapters.DateWiseAdapter;
import com.sanchit.covidtracker.Activities.Adapters.DistrictAdapter;
import com.sanchit.covidtracker.Activities.Adapters.StatewiseDataAdapter;
import com.sanchit.covidtracker.MainActivity;
import com.sanchit.covidtracker.Network.SoleInstance;
import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.databinding.ActivityAllDataBinding;
import com.sanchit.covidtracker.databinding.ActivityAllDataNewBinding;
import com.sanchit.covidtracker.databinding.ActivityAllDataNewDesignBinding;
import com.sanchit.covidtracker.response.AllData.CasesTimeSeries;
import com.sanchit.covidtracker.response.AllData.DataResponse;
import com.sanchit.covidtracker.response.AllData.Statewise;
import com.sanchit.covidtracker.response.DistrictwiseData.DistrictDatum;
import com.sanchit.covidtracker.response.DistrictwiseData.DistrictWiseResponse;
import com.sanchit.covidtracker.response.travelHistory.TravelHistoryResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllDataActivity extends AppCompatActivity implements DateWiseAdapter.OnDateClickListener,
        StatewiseDataAdapter.OnStateSelectListener {


    private ActivityAllDataNewDesignBinding binding;
    private Context context;
    private StatewiseDataAdapter adapter;
    private DateWiseAdapter dateWiseAdapter;
    Animation rotateAnimation;
    private List<Statewise> statewiseList;
    private  List<CasesTimeSeries> dateList;
    private List<DistrictWiseResponse> districsList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_all_data_new_design);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        context = this;
        binding.rvStatewise.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        fetchAllData();
        animation();
        getDistrictwiseData();
        fetchTravelHistory();

        binding.btnStatewise.setOnClickListener(v -> visbileStatewiseLayout());

        binding.btnHome.setOnClickListener(v -> visbileHomeLayout());

        binding.imageView.setOnClickListener(v ->openGraphsActivity());




    }

    private void fetchTravelHistory() {
        Call<TravelHistoryResponse> call  = SoleInstance.getApiServiceInstance().getTravelHistory();

        call.enqueue(new Callback<TravelHistoryResponse>() {
            @Override
            public void onResponse(Call<TravelHistoryResponse> call, Response<TravelHistoryResponse> response) {
                if(response !=null)
                {
                    if(response.body() !=null)
                    {
                        Toast.makeText(context, ""+response.body().getTravelHistory().size(), Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(context, ""+response.message(), Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(context, "null response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TravelHistoryResponse> call, Throwable t) {

                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void openGraphsActivity() {
        Intent intent  = new Intent(context,WorldDataActivity.class);
        startActivity(intent);
    }

    private void getDistrictwiseData() {
        Call<List<DistrictWiseResponse>> call = SoleInstance.getApiServiceInstance().getDataDistrictwise();

        call.enqueue(new Callback<List<DistrictWiseResponse>>() {
            @Override
            public void onResponse(Call<List<DistrictWiseResponse>> call, Response<List<DistrictWiseResponse>> response) {
                if(response!=null)
                {
                    if(response.body() !=null)
                    {
                      districsList = response.body();
                    }else
                    {
                        Toast.makeText(AllDataActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                    }

                }else
                {
                    Toast.makeText(AllDataActivity.this, "null response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<DistrictWiseResponse>> call, Throwable t) {
                Toast.makeText(AllDataActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void visbileHomeLayout() {


        binding.stateLayout.setVisibility(View.GONE);
        binding.btnHome.setVisibility(View.GONE);

        binding.recyclerView.setVisibility(View.VISIBLE);
        binding.homeLayout.setVisibility(View.VISIBLE);
        binding.marqueeText.setVisibility(View.VISIBLE);
        binding.btnStatewise.setVisibility(View.VISIBLE);


    }

    private void visbileStatewiseLayout() {

        binding.recyclerView.setVisibility(View.GONE);
        binding.homeLayout.setVisibility(View.GONE);
        binding.marqueeText.setVisibility(View.GONE);
        binding.btnStatewise.setVisibility(View.GONE);

        binding.stateLayout.setVisibility(View.VISIBLE);
        binding.btnHome.setVisibility(View.VISIBLE);
        fetchAllData();
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

                        statewiseList = response.body().getStatewise();
                        statewiseList.remove(0);
                        adapter = new StatewiseDataAdapter(statewiseList,context);
                        binding.rvStatewise.setAdapter(adapter);
                        binding.recyclerView.setItemViewCacheSize(statewiseList.size());

                        List<CasesTimeSeries> list = response.body().getCasesTimeSeries();
                        Collections.reverse(list);
                        dateList = list;
                        dateWiseAdapter = new DateWiseAdapter(list,context);
                        binding.recyclerView.setAdapter(dateWiseAdapter);
                        binding.recyclerView.setItemViewCacheSize(list.size());
                       // binding.recyclerView.scrollToPosition((response.body().getCasesTimeSeries().size()-1));
                        setMarqueeText(statewiseList);







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

    private void setMarqueeText(List<Statewise> statewiseList) {
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<8; i++)
        {
            if(i==7)
            {
                String text = statewiseList.get(i).getState() + " - "+statewiseList.get(i).getConfirmed();
                builder.append(text);
            }else
            {
                if(i==1)
                {
                    String text = "\t\t\t"+statewiseList.get(i).getState() + " - "+statewiseList.get(i).getConfirmed()+",\t\t";
                    builder.append(text);
                }else
                {
                    String text = statewiseList.get(i).getState() + " - "+statewiseList.get(i).getConfirmed()+",\t\t";
                    builder.append(text);
                }

            }
        }
        binding.marqueeText.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        binding.marqueeText.setText(builder.toString());
        binding.marqueeText.setSelected(true);
        binding.marqueeText.setSingleLine(true);



    }

    private void sendDatatoStateWiseAdapter(List<Statewise> statewise) {

    }


    @Override
    public void onDateClick(int position) {
  //      Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();

        MaterialDialog dateDialog = new MaterialDialog.Builder(context)
                .autoDismiss(true)
                .cancelable(true)
                .canceledOnTouchOutside(true)
                .customView(R.layout.dialog_layout, true)
                .show();


        final TextView tvDate = (TextView)dateDialog.findViewById(R.id.tv_date);
        final TextView tvDailyConfirm = (TextView)dateDialog.findViewById(R.id.tv_d_c);
        final TextView tvDailyRecoverd = (TextView)dateDialog.findViewById(R.id.tv_d_r);
        final TextView tvDailyDeath = (TextView)dateDialog.findViewById(R.id.tv_d_d);
        final TextView tvTotalConfirmed = (TextView)dateDialog.findViewById(R.id.tv_t_c);
        final TextView tvTotalRecovered = (TextView)dateDialog.findViewById(R.id.tv_t_r);
        final TextView tvTotalDeath = (TextView)dateDialog.findViewById(R.id.tv_t_d);


        tvDate.setText("Date: "+dateList.get(position).getDate());
        tvDailyConfirm.setText("Daily Confirmed: "+dateList.get(position).getDailyconfirmed());
        tvDailyRecoverd.setText("Daily Recovered: "+dateList.get(position).getDailyrecovered());
        tvDailyDeath.setText("Daily Deceased: "+dateList.get(position).getDailydeceased());
        tvTotalConfirmed.setText("Total Confirmed: "+dateList.get(position).getTotalconfirmed());
        tvTotalRecovered.setText("Total Recovered: "+dateList.get(position).getTotalrecovered());
        tvTotalDeath.setText("Total Deceased: "+dateList.get(position).getTotaldeceased());


    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public void onStateSelect(String stateName) {

        DistrictAdapter adapter;

        List<DistrictDatum> selectedDistrictList = new ArrayList<>();
        for(int i=0; i<districsList.size(); i++)
        {
            if(stateName.equals(districsList.get(i).getState()))
            {
                selectedDistrictList = districsList.get(i).getDistrictData();
                break;
            }
        }


        MaterialDialog districtDialog = new MaterialDialog.Builder(context)
                .autoDismiss(true)
                .cancelable(true)
                .canceledOnTouchOutside(true)
                .customView(R.layout.district_dialog_layout, true)
                .show();

        final TextView districtName = (TextView) districtDialog.findViewById(R.id.tv_district_name);
        final RecyclerView recyclerView = (RecyclerView) districtDialog.findViewById(R.id.rv_districtList);

        districtName.setText(stateName);

        recyclerView.setLayoutManager(new LinearLayoutManager(districtDialog.getContext()));
        adapter = new DistrictAdapter(districtDialog.getContext(),selectedDistrictList);
        recyclerView.setAdapter(adapter);




    }
}
