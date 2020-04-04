
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Odisha {

    @SerializedName("districtData")
    @Expose
    private DistrictData______________ districtData;

    public DistrictData______________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData______________ districtData) {
        this.districtData = districtData;
    }

}
