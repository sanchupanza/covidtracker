package com.sanchit.covidtracker.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.sanchit.covidtracker.Adapters.DateWiseAdapter;
import com.sanchit.covidtracker.Adapters.DistrictAdapter;
import com.sanchit.covidtracker.Adapters.StatewiseDataAdapter;
import com.sanchit.covidtracker.Adapters.UpdateAdapter;
import com.sanchit.covidtracker.Network.SoleInstance;
import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.Utils.Constants;
import com.sanchit.covidtracker.databinding.ActivityAllDataNewDesignBinding;
import com.sanchit.covidtracker.response.AllData.CasesTimeSeries;
import com.sanchit.covidtracker.response.AllData.DataResponse;
import com.sanchit.covidtracker.response.AllData.Statewise;
import com.sanchit.covidtracker.response.DistrictwiseData.DistrictDatum;
import com.sanchit.covidtracker.response.DistrictwiseData.DistrictWiseResponse;
import com.sanchit.covidtracker.response.UpdatesResponse;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
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
    private List<CasesTimeSeries> dateList;
    private List<DistrictWiseResponse> districsList;
    private List<UpdatesResponse> updateList;
    private String lastUpdateTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_data_new_design);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        context = this;
        binding.rvStatewise.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.rvUpdates.setLayoutManager(new LinearLayoutManager(this));

        fetchAllData();
        animation();
        getDistrictwiseData();
        getUpdates();


        binding.btnStatewise.setOnClickListener(v -> visbileStatewiseLayout());

        binding.btnHome.setOnClickListener(v -> visbileHomeLayout());

        binding.btnMap.setOnClickListener(v -> openGraphsActivity());

        binding.imageView.setOnClickListener(view -> openWorldDataActivity());





       /* Long time = 1586443445L;
       // String date = Constants.getTime(time);

        String timesAgo = Constants.getTimeAgo(time);
        Toast.makeText(context, ""+timesAgo, Toast.LENGTH_SHORT).show();*/





    }

    private void getUpdates() {

        Call<List<UpdatesResponse>> call = SoleInstance.getApiServiceInstance().getUpdates();

        call.enqueue(new Callback<List<UpdatesResponse>>() {
            @Override
            public void onResponse(Call<List<UpdatesResponse>> call, Response<List<UpdatesResponse>> response) {
                if(response.body() !=null)
                {
                    if(response.body().size() > 0)
                    {
                        updateList = response.body();
                        Collections.reverse(updateList);
                        UpdateAdapter adapter = new UpdateAdapter(updateList,context);
                        binding.rvUpdates.setAdapter(adapter);
                    }else
                    {
                        Toast.makeText(AllDataActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(AllDataActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<UpdatesResponse>> call, Throwable t) {
                Toast.makeText(AllDataActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void openWorldDataActivity() {
        startActivity(new Intent(context,WorldDataActivity.class));
    }




    private void openGraphsActivity() {
        Intent intent = new Intent(context, GraphsActivity.class);
        startActivity(intent);
    }

    private void getDistrictwiseData() {
        Call<List<DistrictWiseResponse>> call = SoleInstance.getApiServiceInstance().getDataDistrictwise();

        call.enqueue(new Callback<List<DistrictWiseResponse>>() {
            @Override
            public void onResponse(Call<List<DistrictWiseResponse>> call, Response<List<DistrictWiseResponse>> response) {
                if (response != null) {
                    if (response.body() != null) {
                        districsList = response.body();
                    } else {
                        Toast.makeText(AllDataActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(AllDataActivity.this, "null response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<DistrictWiseResponse>> call, Throwable t) {
                Toast.makeText(AllDataActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
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




    private void animation() {
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        binding.image1.startAnimation(rotateAnimation);

        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.reverse_rotate);
        binding.image2.startAnimation(rotateAnimation);

        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.reverse_rotate);
        binding.image3.startAnimation(rotateAnimation);

        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.reverse_rotate);
        binding.image4.startAnimation(rotateAnimation);


    }

    private void fetchAllData() {
        Call<DataResponse> call = SoleInstance.getApiServiceInstance().getAllData();

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {

                if (response != null) {
                    if (response.body() != null) {

                        lastUpdateTime  = response.body().getStatewise().get(0).getLastupdatedtime();

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date date = null;
                        try {
                            date = sdf.parse(lastUpdateTime);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        PrettyTime p = new PrettyTime();
                        String timeAgo = p.format(date);
                        binding.textView2.setText("LAST UPDATED "+timeAgo.toUpperCase());

                        binding.tvCCount.setText(String.valueOf(response.body().getStatewise().get(0).getConfirmed()));
                        binding.tvACount.setText(String.valueOf(response.body().getStatewise().get(0).getActive()));
                        binding.tvRCount.setText(String.valueOf(response.body().getStatewise().get(0).getRecovered()));
                        binding.tvDCount.setText(String.valueOf(response.body().getStatewise().get(0).getDeaths()));


                        binding.tvCDelCount.setText("+" + response.body().getStatewise().get(0).getDeltaconfirmed());
                        //     binding.tvADelCount.setText("[+"+ response.body().getStatewise().get(0).getDelta().getActive() +"]");
                        binding.tvRDelCount.setText("+" + response.body().getStatewise().get(0).getDeltarecovered());
                        binding.tvDDelCount.setText("+" + response.body().getStatewise().get(0).getDeltadeaths());

                        statewiseList = response.body().getStatewise();
                        setMarqueeText(statewiseList);
                        statewiseList.remove(0);
                        adapter = new StatewiseDataAdapter(statewiseList, context);
                        binding.rvStatewise.setAdapter(adapter);
                        binding.recyclerView.setItemViewCacheSize(statewiseList.size());

                        List<CasesTimeSeries> list = response.body().getCasesTimeSeries();
                        Collections.reverse(list);
                        dateList = list;
                        dateWiseAdapter = new DateWiseAdapter(list, context);
                        binding.recyclerView.setAdapter(dateWiseAdapter);
                        binding.recyclerView.setItemViewCacheSize(list.size());
                        // binding.recyclerView.scrollToPosition((response.body().getCasesTimeSeries().size()-1));


                    } else {
                        Toast.makeText(AllDataActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AllDataActivity.this, "No response", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setMarqueeText(List<Statewise> statewiseList) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < 8; i++) {
            if (i == 7) {
                String text = statewiseList.get(i).getState() + " - " + statewiseList.get(i).getConfirmed();
                builder.append(text);
            } else {
                if (i == 1) {
                    String text = "\t\t\t" + statewiseList.get(i).getState() + " - " + statewiseList.get(i).getConfirmed() + ",\t\t";
                    builder.append(text);
                } else {
                    String text = statewiseList.get(i).getState() + " - " + statewiseList.get(i).getConfirmed() + ",\t\t";
                    builder.append(text);
                }

            }
        }
        binding.marqueeText.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        binding.marqueeText.setText(builder.toString());
        binding.marqueeText.setSelected(true);
        binding.marqueeText.setSingleLine(true);


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


        final TextView tvDate = (TextView) dateDialog.findViewById(R.id.tv_date);
        final TextView tvDailyConfirm = (TextView) dateDialog.findViewById(R.id.tv_d_c);
        final TextView tvDailyRecoverd = (TextView) dateDialog.findViewById(R.id.tv_d_r);
        final TextView tvDailyDeath = (TextView) dateDialog.findViewById(R.id.tv_d_d);
        final TextView tvTotalConfirmed = (TextView) dateDialog.findViewById(R.id.tv_t_c);
        final TextView tvTotalRecovered = (TextView) dateDialog.findViewById(R.id.tv_t_r);
        final TextView tvTotalDeath = (TextView) dateDialog.findViewById(R.id.tv_t_d);


        tvDate.setText("Date: " + dateList.get(position).getDate()+" 2020");
        tvDailyConfirm.setText("Confirmed: " + dateList.get(position).getDailyconfirmed());
        tvDailyRecoverd.setText("Recovered: " + dateList.get(position).getDailyrecovered());
        tvDailyDeath.setText("Deceased: " + dateList.get(position).getDailydeceased());
        tvTotalConfirmed.setText("Total Confirmed: " + dateList.get(position).getTotalconfirmed());
        tvTotalRecovered.setText("Total Recovered: " + dateList.get(position).getTotalrecovered());
        tvTotalDeath.setText("Total Deceased: " + dateList.get(position).getTotaldeceased());


    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.warn)
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
        for (int i = 0; i < districsList.size(); i++) {
            if (stateName.equals(districsList.get(i).getState())) {
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
        adapter = new DistrictAdapter(districtDialog.getContext(), selectedDistrictList);
        recyclerView.setAdapter(adapter);


    }
}
