package com.sanchit.covidtracker.response.rawData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RawDataResponse {
    @SerializedName("raw_data")
    @Expose
    private List<RawDatum> rawData = null;

    public List<RawDatum> getRawData() {
        return rawData;
    }

    public void setRawData(List<RawDatum> rawData) {
        this.rawData = rawData;
    }
}
