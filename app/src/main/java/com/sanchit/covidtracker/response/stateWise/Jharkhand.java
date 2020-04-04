
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Jharkhand {

    @SerializedName("districtData")
    @Expose
    private DistrictData___________________________ districtData;

    public DistrictData___________________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData___________________________ districtData) {
        this.districtData = districtData;
    }

}
