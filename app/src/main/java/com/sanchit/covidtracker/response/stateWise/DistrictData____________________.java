
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData____________________ {

    @SerializedName("Kangra")
    @Expose
    private Kangra kangra;
    @SerializedName("Una")
    @Expose
    private Una una;

    public Kangra getKangra() {
        return kangra;
    }

    public void setKangra(Kangra kangra) {
        this.kangra = kangra;
    }

    public Una getUna() {
        return una;
    }

    public void setUna(Una una) {
        this.una = una;
    }

}
