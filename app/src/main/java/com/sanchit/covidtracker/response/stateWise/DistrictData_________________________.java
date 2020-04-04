
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData_________________________ {

    @SerializedName("North Goa")
    @Expose
    private NorthGoa northGoa;
    @SerializedName("Unknown")
    @Expose
    private Unknown_____________ unknown;

    public NorthGoa getNorthGoa() {
        return northGoa;
    }

    public void setNorthGoa(NorthGoa northGoa) {
        this.northGoa = northGoa;
    }

    public Unknown_____________ getUnknown() {
        return unknown;
    }

    public void setUnknown(Unknown_____________ unknown) {
        this.unknown = unknown;
    }

}
