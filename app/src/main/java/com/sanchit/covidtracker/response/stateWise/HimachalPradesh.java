
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HimachalPradesh {

    @SerializedName("districtData")
    @Expose
    private DistrictData____________________ districtData;

    public DistrictData____________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData____________________ districtData) {
        this.districtData = districtData;
    }

}
