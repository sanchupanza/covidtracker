
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Goa {

    @SerializedName("districtData")
    @Expose
    private DistrictData_________________________ districtData;

    public DistrictData_________________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData_________________________ districtData) {
        this.districtData = districtData;
    }

}
