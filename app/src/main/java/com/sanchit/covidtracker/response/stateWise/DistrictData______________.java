
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData______________ {

    @SerializedName("Khordha")
    @Expose
    private Khordha khordha;
    @SerializedName("Bhadrak")
    @Expose
    private Bhadrak bhadrak;
    @SerializedName("Cuttack")
    @Expose
    private Cuttack cuttack;
    @SerializedName("Puri")
    @Expose
    private Puri puri;
    @SerializedName("Jajapur")
    @Expose
    private Jajapur jajapur;

    public Khordha getKhordha() {
        return khordha;
    }

    public void setKhordha(Khordha khordha) {
        this.khordha = khordha;
    }

    public Bhadrak getBhadrak() {
        return bhadrak;
    }

    public void setBhadrak(Bhadrak bhadrak) {
        this.bhadrak = bhadrak;
    }

    public Cuttack getCuttack() {
        return cuttack;
    }

    public void setCuttack(Cuttack cuttack) {
        this.cuttack = cuttack;
    }

    public Puri getPuri() {
        return puri;
    }

    public void setPuri(Puri puri) {
        this.puri = puri;
    }

    public Jajapur getJajapur() {
        return jajapur;
    }

    public void setJajapur(Jajapur jajapur) {
        this.jajapur = jajapur;
    }

}
