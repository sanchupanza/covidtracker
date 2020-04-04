
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Assam {

    @SerializedName("districtData")
    @Expose
    private DistrictData____________________________ districtData;

    public DistrictData____________________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData____________________________ districtData) {
        this.districtData = districtData;
    }

}
