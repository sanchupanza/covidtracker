
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Karnataka {

    @SerializedName("districtData")
    @Expose
    private DistrictData_________ districtData;

    public DistrictData_________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData_________ districtData) {
        this.districtData = districtData;
    }

}
