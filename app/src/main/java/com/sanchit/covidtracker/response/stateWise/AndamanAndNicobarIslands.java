
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AndamanAndNicobarIslands {

    @SerializedName("districtData")
    @Expose
    private DistrictData__________________________ districtData;

    public DistrictData__________________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData__________________________ districtData) {
        this.districtData = districtData;
    }

}
