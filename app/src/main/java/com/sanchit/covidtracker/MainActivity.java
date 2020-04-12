package com.sanchit.covidtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;


import com.sanchit.covidtracker.Activities.AllDataActivity;
import com.sanchit.covidtracker.Adapters.UpdateAdapter;
import com.sanchit.covidtracker.BannerLibrary.BannerLayout;
import com.sanchit.covidtracker.BannerLibrary.WebBannerAdapter;
import com.sanchit.covidtracker.Network.SoleInstance;
import com.sanchit.covidtracker.databinding.ActivityMainBinding;
import com.sanchit.covidtracker.response.AllData.DataResponse;
import com.sanchit.covidtracker.response.UpdatesResponse;
import com.sanchit.covidtracker.response.rawData.RawDataResponse;

import com.sanchit.covidtracker.response.travelHistory.TravelHistoryResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private Context context;
    private List<UpdatesResponse> updateList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

       /* BannerLayout recyclerBanner =  (BannerLayout) findViewById(R.id.recycler);
        BannerLayout bannerVertical =  (BannerLayout) findViewById(R.id.recycler_ver);*/

        List<String> list = new ArrayList<>();
        list.add("http://img0.imgtn.bdimg.com/it/u=1352823040,1166166164&fm=27&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=2293177440,3125900197&fm=27&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=3967183915,4078698000&fm=27&gp=0.jpg");
        list.add("http://img0.imgtn.bdimg.com/it/u=3184221534,2238244948&fm=27&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=1794621527,1964098559&fm=27&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=1243617734,335916716&fm=27&gp=0.jpg");


        getUpdates();

    //    WebBannerAdapter webBannerAdapter=new WebBannerAdapter(this,list);

   //     WebBannerAdapter WebBannerAdapter2 =new WebBannerAdapter(this,list);

   //     binding.recycler.setAdapter(webBannerAdapter);
   //     binding.recyclerVer.setAdapter(WebBannerAdapter2);
      /*  recyclerBanner.setAdapter(webBannerAdapter);
        bannerVertical.setAdapter(WebBannerAdapter2);
*/

        // fetchAllData();
    //    fetchStateWiseData();
    //    fetchTravelHistory();
    //    fetchRawData();


   /*     https://api.covid19india.org/data.json

        https://api.covid19india.org/state_district_wise.json

        https://api.covid19india.org/travel_history.json

        https://api.covid19india.org/raw_data.json
*/



   








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
                        WebBannerAdapter webBannerAdapter=new WebBannerAdapter(MainActivity.this,updateList);
                        binding.recycler.setAdapter(webBannerAdapter);


                    }else
                    {
                        Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(MainActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<UpdatesResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchRawData() {
        Call<RawDataResponse> call = SoleInstance.getApiServiceInstance().getRawData();

        call.enqueue(new Callback<RawDataResponse>() {
            @Override
            public void onResponse(Call<RawDataResponse> call, Response<RawDataResponse> response) {
                if(response !=null)
                {
                    if(response.body() !=null)
                    {
                        Toast.makeText(MainActivity.this, ""+response.body().getRawData().size(), Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(MainActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(MainActivity.this, "null response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RawDataResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
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
                        Toast.makeText(MainActivity.this, ""+response.body().getTravelHistory().size(), Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(MainActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(MainActivity.this, "null response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TravelHistoryResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }



    private void fetchAllData() {
        Call<DataResponse> call = SoleInstance.getApiServiceInstance().getAllData();

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {

                if(response.body().getCasesTimeSeries().size()>0)
                {
                    Toast.makeText(MainActivity.this, "data fetchhed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
