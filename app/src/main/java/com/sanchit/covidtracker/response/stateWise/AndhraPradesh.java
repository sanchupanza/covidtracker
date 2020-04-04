
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AndhraPradesh {

    @SerializedName("districtData")
    @Expose
    private DistrictData____________ districtData;

    public DistrictData____________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData____________ districtData) {
        this.districtData = districtData;
    }

}
