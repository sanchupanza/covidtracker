
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MadhyaPradesh {

    @SerializedName("districtData")
    @Expose
    private DistrictData_____________________ districtData;

    public DistrictData_____________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData_____________________ districtData) {
        this.districtData = districtData;
    }

}
