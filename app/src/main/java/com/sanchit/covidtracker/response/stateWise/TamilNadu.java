
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TamilNadu {

    @SerializedName("districtData")
    @Expose
    private DistrictData_______ districtData;

    public DistrictData_______ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData_______ districtData) {
        this.districtData = districtData;
    }

}
