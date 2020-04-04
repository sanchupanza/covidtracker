
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chhattisgarh {

    @SerializedName("districtData")
    @Expose
    private DistrictData__________________ districtData;

    public DistrictData__________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData__________________ districtData) {
        this.districtData = districtData;
    }

}
