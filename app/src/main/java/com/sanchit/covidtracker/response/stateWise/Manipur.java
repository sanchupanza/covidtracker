
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Manipur {

    @SerializedName("districtData")
    @Expose
    private DistrictData_______________________ districtData;

    public DistrictData_______________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData_______________________ districtData) {
        this.districtData = districtData;
    }

}
