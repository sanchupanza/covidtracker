
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Maharashtra {

    @SerializedName("districtData")
    @Expose
    private DistrictData__________ districtData;

    public DistrictData__________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData__________ districtData) {
        this.districtData = districtData;
    }

}
