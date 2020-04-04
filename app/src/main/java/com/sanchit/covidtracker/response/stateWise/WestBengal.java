
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WestBengal {

    @SerializedName("districtData")
    @Expose
    private DistrictData________________ districtData;

    public DistrictData________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData________________ districtData) {
        this.districtData = districtData;
    }

}
