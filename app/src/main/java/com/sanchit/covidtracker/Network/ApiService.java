package com.sanchit.covidtracker.Network;

import com.sanchit.covidtracker.response.AllData.DataResponse;
import com.sanchit.covidtracker.response.rawData.RawDataResponse;
import com.sanchit.covidtracker.response.stateWise.StatewiseResponse;
import com.sanchit.covidtracker.response.travelHistory.TravelHistoryResponse;


import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {


    @GET("data.json")
    Call<DataResponse> getAllData();


    @GET("state_district_wise.json")
    Call<StatewiseResponse> getDataDistrictwise();


    @GET("travel_history.json")
    Call<TravelHistoryResponse> getTravelHistory();


    @GET("raw_data.json")
    Call<RawDataResponse> getRawData();


    @GET("summary")
    Call<RawDataResponse> getSummary();


}
