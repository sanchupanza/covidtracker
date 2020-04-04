
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Telangana {

    @SerializedName("districtData")
    @Expose
    private DistrictData__ districtData;

    public DistrictData__ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData__ districtData) {
        this.districtData = districtData;
    }

}
