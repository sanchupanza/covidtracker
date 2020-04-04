
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rajasthan {

    @SerializedName("districtData")
    @Expose
    private DistrictData___ districtData;

    public DistrictData___ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData___ districtData) {
        this.districtData = districtData;
    }

}
