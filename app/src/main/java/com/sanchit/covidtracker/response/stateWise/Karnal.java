
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Karnal {

    @SerializedName("confirmed")
    @Expose
    private Integer confirmed;
    @SerializedName("lastupdatedtime")
    @Expose
    private String lastupdatedtime;
    @SerializedName("delta")
    @Expose
    private Delta________________________________________________________ delta;

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public String getLastupdatedtime() {
        return lastupdatedtime;
    }

    public void setLastupdatedtime(String lastupdatedtime) {
        this.lastupdatedtime = lastupdatedtime;
    }

    public Delta________________________________________________________ getDelta() {
        return delta;
    }

    public void setDelta(Delta________________________________________________________ delta) {
        this.delta = delta;
    }

}