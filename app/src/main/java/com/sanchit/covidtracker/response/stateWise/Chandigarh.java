
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chandigarh {

    @SerializedName("districtData")
    @Expose
    private DistrictData_________________ districtData;

    public DistrictData_________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData_________________ districtData) {
        this.districtData = districtData;
    }

}
