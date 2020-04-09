package com.sanchit.covidtracker.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdatesResponse {

    @SerializedName("update")
    @Expose
    private String update;
    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

}