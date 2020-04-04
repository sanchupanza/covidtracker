
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Delhi {

    @SerializedName("districtData")
    @Expose
    private DistrictData_ districtData;

    public DistrictData_ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData_ districtData) {
        this.districtData = districtData;
    }

}
