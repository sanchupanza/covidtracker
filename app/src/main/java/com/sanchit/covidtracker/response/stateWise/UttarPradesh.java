
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UttarPradesh {

    @SerializedName("districtData")
    @Expose
    private DistrictData_____ districtData;

    public DistrictData_____ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData_____ districtData) {
        this.districtData = districtData;
    }

}
