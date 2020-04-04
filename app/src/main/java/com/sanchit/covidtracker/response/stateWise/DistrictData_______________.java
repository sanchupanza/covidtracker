
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData_______________ {

    @SerializedName("Mahe")
    @Expose
    private Mahe mahe;
    @SerializedName("Puducherry")
    @Expose
    private Puducherry_ puducherry;

    public Mahe getMahe() {
        return mahe;
    }

    public void setMahe(Mahe mahe) {
        this.mahe = mahe;
    }

    public Puducherry_ getPuducherry() {
        return puducherry;
    }

    public void setPuducherry(Puducherry_ puducherry) {
        this.puducherry = puducherry;
    }

}
