
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gujarat {

    @SerializedName("districtData")
    @Expose
    private DistrictData___________________ districtData;

    public DistrictData___________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData___________________ districtData) {
        this.districtData = districtData;
    }

}
