
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kerala {

    @SerializedName("districtData")
    @Expose
    private DistrictData districtData;

    public DistrictData getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData districtData) {
        this.districtData = districtData;
    }

}
