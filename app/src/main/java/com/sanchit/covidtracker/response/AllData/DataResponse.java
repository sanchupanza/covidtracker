package com.sanchit.covidtracker.response.AllData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {

    @SerializedName("cases_time_series")
    @Expose
    private List<CasesTimeSeries> casesTimeSeries = null;
    @SerializedName("key_values")
    @Expose
    private List<KeyValue> keyValues = null;
    @SerializedName("statewise")
    @Expose
    private List<Statewise> statewise = null;

    public List<CasesTimeSeries> getCasesTimeSeries() {
        return casesTimeSeries;
    }

    public void setCasesTimeSeries(List<CasesTimeSeries> casesTimeSeries) {
        this.casesTimeSeries = casesTimeSeries;
    }

    public List<KeyValue> getKeyValues() {
        return keyValues;
    }

    public void setKeyValues(List<KeyValue> keyValues) {
        this.keyValues = keyValues;
    }

    public List<Statewise> getStatewise() {
        return statewise;
    }

    public void setStatewise(List<Statewise> statewise) {
        this.statewise = statewise;
    }
}
