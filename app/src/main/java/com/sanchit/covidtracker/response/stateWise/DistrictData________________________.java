
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData________________________ {

    @SerializedName("Aizawl")
    @Expose
    private Aizawl aizawl;

    public Aizawl getAizawl() {
        return aizawl;
    }

    public void setAizawl(Aizawl aizawl) {
        this.aizawl = aizawl;
    }

}
