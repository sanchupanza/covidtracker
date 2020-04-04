
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uttarakhand {

    @SerializedName("districtData")
    @Expose
    private DistrictData_____________ districtData;

    public DistrictData_____________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData_____________ districtData) {
        this.districtData = districtData;
    }

}
