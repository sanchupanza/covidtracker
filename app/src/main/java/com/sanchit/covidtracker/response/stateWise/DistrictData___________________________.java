
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData___________________________ {

    @SerializedName("Ranchi")
    @Expose
    private Ranchi ranchi;
    @SerializedName("Hazaribagh")
    @Expose
    private Hazaribagh hazaribagh;

    public Ranchi getRanchi() {
        return ranchi;
    }

    public void setRanchi(Ranchi ranchi) {
        this.ranchi = ranchi;
    }

    public Hazaribagh getHazaribagh() {
        return hazaribagh;
    }

    public void setHazaribagh(Hazaribagh hazaribagh) {
        this.hazaribagh = hazaribagh;
    }

}
