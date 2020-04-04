
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData________________ {

    @SerializedName("Kolkata")
    @Expose
    private Kolkata kolkata;
    @SerializedName("North 24 Parganas")
    @Expose
    private North24Parganas north24Parganas;
    @SerializedName("Nadia")
    @Expose
    private Nadia nadia;
    @SerializedName("Medinipur East")
    @Expose
    private MedinipurEast medinipurEast;
    @SerializedName("Kalimpong")
    @Expose
    private Kalimpong kalimpong;
    @SerializedName("Hooghly")
    @Expose
    private Hooghly hooghly;
    @SerializedName("Howrah")
    @Expose
    private Howrah howrah;
    @SerializedName("South 24 Parganas")
    @Expose
    private South24Parganas south24Parganas;
    @SerializedName("Unknown")
    @Expose
    private Unknown________ unknown;

    public Kolkata getKolkata() {
        return kolkata;
    }

    public void setKolkata(Kolkata kolkata) {
        this.kolkata = kolkata;
    }

    public North24Parganas getNorth24Parganas() {
        return north24Parganas;
    }

    public void setNorth24Parganas(North24Parganas north24Parganas) {
        this.north24Parganas = north24Parganas;
    }

    public Nadia getNadia() {
        return nadia;
    }

    public void setNadia(Nadia nadia) {
        this.nadia = nadia;
    }

    public MedinipurEast getMedinipurEast() {
        return medinipurEast;
    }

    public void setMedinipurEast(MedinipurEast medinipurEast) {
        this.medinipurEast = medinipurEast;
    }

    public Kalimpong getKalimpong() {
        return kalimpong;
    }

    public void setKalimpong(Kalimpong kalimpong) {
        this.kalimpong = kalimpong;
    }

    public Hooghly getHooghly() {
        return hooghly;
    }

    public void setHooghly(Hooghly hooghly) {
        this.hooghly = hooghly;
    }

    public Howrah getHowrah() {
        return howrah;
    }

    public void setHowrah(Howrah howrah) {
        this.howrah = howrah;
    }

    public South24Parganas getSouth24Parganas() {
        return south24Parganas;
    }

    public void setSouth24Parganas(South24Parganas south24Parganas) {
        this.south24Parganas = south24Parganas;
    }

    public Unknown________ getUnknown() {
        return unknown;
    }

    public void setUnknown(Unknown________ unknown) {
        this.unknown = unknown;
    }

}
