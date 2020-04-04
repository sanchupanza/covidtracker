
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData_ {

    @SerializedName("East Delhi")
    @Expose
    private EastDelhi eastDelhi;
    @SerializedName("South West Delhi")
    @Expose
    private SouthWestDelhi southWestDelhi;
    @SerializedName("West Delhi")
    @Expose
    private WestDelhi westDelhi;
    @SerializedName("North Delhi")
    @Expose
    private NorthDelhi northDelhi;
    @SerializedName("New Delhi")
    @Expose
    private NewDelhi newDelhi;
    @SerializedName("South Delhi")
    @Expose
    private SouthDelhi southDelhi;
    @SerializedName("North East Delhi")
    @Expose
    private NorthEastDelhi northEastDelhi;
    @SerializedName("North West Delhi")
    @Expose
    private NorthWestDelhi northWestDelhi;
    @SerializedName("Unknown")
    @Expose
    private Unknown unknown;

    public EastDelhi getEastDelhi() {
        return eastDelhi;
    }

    public void setEastDelhi(EastDelhi eastDelhi) {
        this.eastDelhi = eastDelhi;
    }

    public SouthWestDelhi getSouthWestDelhi() {
        return southWestDelhi;
    }

    public void setSouthWestDelhi(SouthWestDelhi southWestDelhi) {
        this.southWestDelhi = southWestDelhi;
    }

    public WestDelhi getWestDelhi() {
        return westDelhi;
    }

    public void setWestDelhi(WestDelhi westDelhi) {
        this.westDelhi = westDelhi;
    }

    public NorthDelhi getNorthDelhi() {
        return northDelhi;
    }

    public void setNorthDelhi(NorthDelhi northDelhi) {
        this.northDelhi = northDelhi;
    }

    public NewDelhi getNewDelhi() {
        return newDelhi;
    }

    public void setNewDelhi(NewDelhi newDelhi) {
        this.newDelhi = newDelhi;
    }

    public SouthDelhi getSouthDelhi() {
        return southDelhi;
    }

    public void setSouthDelhi(SouthDelhi southDelhi) {
        this.southDelhi = southDelhi;
    }

    public NorthEastDelhi getNorthEastDelhi() {
        return northEastDelhi;
    }

    public void setNorthEastDelhi(NorthEastDelhi northEastDelhi) {
        this.northEastDelhi = northEastDelhi;
    }

    public NorthWestDelhi getNorthWestDelhi() {
        return northWestDelhi;
    }

    public void setNorthWestDelhi(NorthWestDelhi northWestDelhi) {
        this.northWestDelhi = northWestDelhi;
    }

    public Unknown getUnknown() {
        return unknown;
    }

    public void setUnknown(Unknown unknown) {
        this.unknown = unknown;
    }

}
