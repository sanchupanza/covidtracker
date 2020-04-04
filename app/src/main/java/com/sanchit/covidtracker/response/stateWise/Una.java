
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Una {

    @SerializedName("confirmed")
    @Expose
    private Integer confirmed;
    @SerializedName("lastupdatedtime")
    @Expose
    private String lastupdatedtime;
    @SerializedName("delta")
    @Expose
    private Delta_______________________________________________________________________________________________________________________________________________________________________________________________________ delta;

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

    public Delta_______________________________________________________________________________________________________________________________________________________________________________________________________ getDelta() {
        return delta;
    }

    public void setDelta(Delta_______________________________________________________________________________________________________________________________________________________________________________________________________ delta) {
        this.delta = delta;
    }

}
