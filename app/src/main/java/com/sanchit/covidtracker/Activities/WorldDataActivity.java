package com.sanchit.covidtracker.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sanchit.covidtracker.Adapters.CountryAdapter;
import com.sanchit.covidtracker.Network.WorldSoleInstance;
import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.Utils.Constants;
import com.sanchit.covidtracker.databinding.ActivityWorldDataBinding;
import com.sanchit.covidtracker.response.WorldSummary.CountriesResponse;
import com.sanchit.covidtracker.response.WorldSummary.Country;

import org.joda.time.Instant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorldDataActivity extends AppCompatActivity {

    private ActivityWorldDataBinding binding;
    private Context context;
    private Animation rotateAnimation;
    private String date;
    private List<Country> countryList;
    private CountryAdapter adapter;
    private TinyDB tinydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_world_data);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        context = this;
        tinydb = new TinyDB(context);
        getData();


        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        binding.imgVirus.startAnimation(rotateAnimation);


        binding.back.setOnClickListener(view -> finish());

        binding.rvcontry.setLayoutManager(new LinearLayoutManager(this));

    }






    private void getData() {
        Call<CountriesResponse> call = WorldSoleInstance.getApiServiceInstance().getSummary();

        call.enqueue(new Callback<CountriesResponse>() {
            @Override
            public void onResponse(Call<CountriesResponse> call, Response<CountriesResponse> response) {
                if(response !=null)
                {
                    if(response.body() !=null)
                    {
                        date = response.body().getDate();
                        binding.tvCCount.setText(String.valueOf(response.body().getGlobal().getTotalConfirmed()));
                        binding.tvCDelCount.setText("+"+ response.body().getGlobal().getNewConfirmed());
                        binding.tvRCount.setText(String.valueOf(response.body().getGlobal().getTotalRecovered() ));
                        binding.tvRDelCount.setText("+"+ response.body().getGlobal().getNewRecovered());
                        binding.tvDCount.setText(String.valueOf(response.body().getGlobal().getTotalDeaths()));
                        binding.tvDDelCount.setText("+"+ response.body().getGlobal().getNewDeaths());
                        countryList = response.body().getCountries();
                        countryList.remove(0);
                        Collections.sort(countryList,Country::compareTo);
                        Collections.reverse(countryList);
                        tinydb.putString("json",new Gson().toJson(countryList));
                        tinydb.putString("tc",String.valueOf(response.body().getGlobal().getTotalConfirmed()));
                        tinydb.putString("nc",String.valueOf(response.body().getGlobal().getNewConfirmed()));
                        tinydb.putString("tr",String.valueOf(response.body().getGlobal().getTotalRecovered()));
                        tinydb.putString("nr",String.valueOf(response.body().getGlobal().getNewRecovered()));
                        tinydb.putString("td",String.valueOf(response.body().getGlobal().getTotalDeaths()));
                        tinydb.putString("nd",String.valueOf(response.body().getGlobal().getNewDeaths()));
                        tinydb.putString("date",date);
                        adapter  = new CountryAdapter(context,countryList);
                        binding.rvcontry.setAdapter(adapter);
                        binding.rvcontry.setItemViewCacheSize(countryList.size());

                        binding.textView2.setText("Last Updated "+Constants.getTimesAgo(date)+", "+date);
                     //   setData();
                      //  Toast.makeText(WorldDataActivity.this, ""+response.body().getCountries().size(), Toast.LENGTH_SHORT).show();

                    }else
                    {
                        showOfflineData();

                    }
                }else
                {

                    showOfflineData();

                }
            }

            @Override
            public void onFailure(Call<CountriesResponse> call, Throwable t) {
                showOfflineData();
            }
        });
    }

    private void showOfflineData() {
        Toast.makeText(context, "showing offline data", Toast.LENGTH_SHORT).show();
        Country[] countryArray = new Gson().fromJson(tinydb.getString("json"),Country[].class);
        List<Country> newCountryList = new ArrayList<>();

        for(Country c : countryArray)
        {
            newCountryList.add(c);
        }
        adapter  = new CountryAdapter(context,newCountryList);
        binding.rvcontry.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        binding.rvcontry.setItemViewCacheSize(newCountryList.size());
        binding.textView2.setText("Last Updated "+Constants.getTimesAgo(tinydb.getString("date"))+", "+tinydb.getString("date"));
        binding.tvCCount.setText(tinydb.getString("tc"));
        binding.tvCDelCount.setText("+"+ tinydb.getString("nc"));
        binding.tvRCount.setText(tinydb.getString("tr"));
        binding.tvRDelCount.setText("+"+ tinydb.getString("nr"));
        binding.tvDCount.setText(tinydb.getString("td"));
        binding.tvDDelCount.setText("+"+ tinydb.getString("nd"));
    }

}
