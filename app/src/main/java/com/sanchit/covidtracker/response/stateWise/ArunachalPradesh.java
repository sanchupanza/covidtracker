
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArunachalPradesh {

    @SerializedName("districtData")
    @Expose
    private DistrictData_____________________________ districtData;

    public DistrictData_____________________________ getDistrictData() {
        return districtData;
    }

    public void setDistrictData(DistrictData_____________________________ districtData) {
        this.districtData = districtData;
    }

}
