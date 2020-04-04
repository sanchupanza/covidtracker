
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mizoram {

    @SerializedName("districtData")
    @Expose
    private DistrictData________________________ districtData;

    public DistrictData________________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData________________________ districtData) {
        this.districtData = districtData;
    }

}
