
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData__________________ {

    @SerializedName("Raipur")
    @Expose
    private Raipur raipur;
    @SerializedName("Rajnandgaon")
    @Expose
    private Rajnandgaon rajnandgaon;
    @SerializedName("Bilaspur")
    @Expose
    private Bilaspur bilaspur;
    @SerializedName("Durg")
    @Expose
    private Durg durg;
    @SerializedName("Korba")
    @Expose
    private Korba korba;

    public Raipur getRaipur() {
        return raipur;
    }

    public void setRaipur(Raipur raipur) {
        this.raipur = raipur;
    }

    public Rajnandgaon getRajnandgaon() {
        return rajnandgaon;
    }

    public void setRajnandgaon(Rajnandgaon rajnandgaon) {
        this.rajnandgaon = rajnandgaon;
    }

    public Bilaspur getBilaspur() {
        return bilaspur;
    }

    public void setBilaspur(Bilaspur bilaspur) {
        this.bilaspur = bilaspur;
    }

    public Durg getDurg() {
        return durg;
    }

    public void setDurg(Durg durg) {
        this.durg = durg;
    }

    public Korba getKorba() {
        return korba;
    }

    public void setKorba(Korba korba) {
        this.korba = korba;
    }

}
