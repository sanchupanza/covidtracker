
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Punjab {

    @SerializedName("districtData")
    @Expose
    private DistrictData___________ districtData;

    public DistrictData___________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData___________ districtData) {
        this.districtData = districtData;
    }

}
