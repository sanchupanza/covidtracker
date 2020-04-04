
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData_______________________ {

    @SerializedName("Imphal West")
    @Expose
    private ImphalWest imphalWest;
    @SerializedName("Unknown")
    @Expose
    private Unknown____________ unknown;

    public ImphalWest getImphalWest() {
        return imphalWest;
    }

    public void setImphalWest(ImphalWest imphalWest) {
        this.imphalWest = imphalWest;
    }

    public Unknown____________ getUnknown() {
        return unknown;
    }

    public void setUnknown(Unknown____________ unknown) {
        this.unknown = unknown;
    }

}
