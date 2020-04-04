
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Puducherry {

    @SerializedName("districtData")
    @Expose
    private DistrictData_______________ districtData;

    public DistrictData_______________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData_______________ districtData) {
        this.districtData = districtData;
    }

}
