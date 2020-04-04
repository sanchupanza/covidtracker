
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ladakh {

    @SerializedName("districtData")
    @Expose
    private DistrictData______ districtData;

    public DistrictData______ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData______ districtData) {
        this.districtData = districtData;
    }

}
