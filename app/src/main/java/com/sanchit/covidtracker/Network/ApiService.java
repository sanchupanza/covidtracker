package com.sanchit.covidtracker.Network;

import com.sanchit.covidtracker.response.AllData.DataResponse;
import com.sanchit.covidtracker.response.DistrictwiseData.DistrictWiseResponse;
import com.sanchit.covidtracker.response.UpdatesResponse;
import com.sanchit.covidtracker.response.WorldSummary.CountriesResponse;
import com.sanchit.covidtracker.response.rawData.RawDataResponse;

import com.sanchit.covidtracker.response.travelHistory.TravelHistoryResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {


    @GET("data.json")
    Call<DataResponse> getAllData();


    @GET("updatelog/log.json")
    Call<List<UpdatesResponse>> getUpdates();


    @GET("v2/state_district_wise.json")
    Call <List<DistrictWiseResponse>> getDataDistrictwise();


    @GET("travel_history.json")
    Call<TravelHistoryResponse> getTravelHistory();


    @GET("raw_data.json")
    Call<RawDataResponse> getRawData();


    @GET("summary")
    Call<CountriesResponse> getSummary();


}
