
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Haryana {

    @SerializedName("districtData")
    @Expose
    private DistrictData____ districtData;

    public DistrictData____ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData____ districtData) {
        this.districtData = districtData;
    }

}
