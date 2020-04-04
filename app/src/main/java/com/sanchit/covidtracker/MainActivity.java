package com.sanchit.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.sanchit.covidtracker.Network.SoleInstance;
import com.sanchit.covidtracker.response.AllData.DataResponse;
import com.sanchit.covidtracker.response.rawData.RawDataResponse;
import com.sanchit.covidtracker.response.stateWise.Delhi;
import com.sanchit.covidtracker.response.stateWise.StatewiseResponse;
import com.sanchit.covidtracker.response.travelHistory.TravelHistoryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchAllData();
    //    fetchStateWiseData();
    //    fetchTravelHistory();
    //    fetchRawData();


   /*     https://api.covid19india.org/data.json

        https://api.covid19india.org/state_district_wise.json

        https://api.covid19india.org/travel_history.json

        https://api.covid19india.org/raw_data.json
*/











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

    private void fetchStateWiseData() {

        Call<StatewiseResponse> call = SoleInstance.getApiServiceInstance().getDataDistrictwise();

        call.enqueue(new Callback<StatewiseResponse>() {
            @Override
            public void onResponse(Call<StatewiseResponse> call, Response<StatewiseResponse> response) {
                if(response !=null)
                {
                    if(response.body() !=null)
                    {
                        Toast.makeText(MainActivity.this, ""+response.body().getDelhi().getDistrictData().getEastDelhi().getDelta().getConfirmed(), Toast.LENGTH_SHORT).show();
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
            public void onFailure(Call<StatewiseResponse> call, Throwable t) {
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
