
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData__________________________ {

    @SerializedName("South Andaman")
    @Expose
    private SouthAndaman southAndaman;
    @SerializedName("North and Middle Andaman")
    @Expose
    private NorthAndMiddleAndaman northAndMiddleAndaman;
    @SerializedName("Unknown")
    @Expose
    private Unknown______________ unknown;

    public SouthAndaman getSouthAndaman() {
        return southAndaman;
    }

    public void setSouthAndaman(SouthAndaman southAndaman) {
        this.southAndaman = southAndaman;
    }

    public NorthAndMiddleAndaman getNorthAndMiddleAndaman() {
        return northAndMiddleAndaman;
    }

    public void setNorthAndMiddleAndaman(NorthAndMiddleAndaman northAndMiddleAndaman) {
        this.northAndMiddleAndaman = northAndMiddleAndaman;
    }

    public Unknown______________ getUnknown() {
        return unknown;
    }

    public void setUnknown(Unknown______________ unknown) {
        this.unknown = unknown;
    }

}
