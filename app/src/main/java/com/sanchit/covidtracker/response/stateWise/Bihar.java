
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bihar {

    @SerializedName("districtData")
    @Expose
    private DistrictData______________________ districtData;

    public DistrictData______________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData______________________ districtData) {
        this.districtData = districtData;
    }

}
