
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JammuAndKashmir {

    @SerializedName("districtData")
    @Expose
    private DistrictData________ districtData;

    public DistrictData________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData________ districtData) {
        this.districtData = districtData;
    }

}
