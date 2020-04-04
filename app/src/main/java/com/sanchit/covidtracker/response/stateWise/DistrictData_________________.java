
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData_________________ {

    @SerializedName("Chandigarh")
    @Expose
    private Chandigarh_ chandigarh;
    @SerializedName("Unknown")
    @Expose
    private Unknown_________ unknown;

    public Chandigarh_ getChandigarh() {
        return chandigarh;
    }

    public void setChandigarh(Chandigarh_ chandigarh) {
        this.chandigarh = chandigarh;
    }

    public Unknown_________ getUnknown() {
        return unknown;
    }

    public void setUnknown(Unknown_________ unknown) {
        this.unknown = unknown;
    }

}
