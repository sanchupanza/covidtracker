
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData____________________________ {

    @SerializedName("Cachar")
    @Expose
    private Cachar cachar;
    @SerializedName("Kamrup Metropolitan")
    @Expose
    private KamrupMetropolitan kamrupMetropolitan;
    @SerializedName("Jorhat")
    @Expose
    private Jorhat jorhat;
    @SerializedName("Goalpara")
    @Expose
    private Goalpara goalpara;
    @SerializedName("Nalbari")
    @Expose
    private Nalbari nalbari;
    @SerializedName("South Salmara Mancachar")
    @Expose
    private SouthSalmaraMancachar southSalmaraMancachar;
    @SerializedName("Kamrup")
    @Expose
    private Kamrup kamrup;
    @SerializedName("Morigaon")
    @Expose
    private Morigaon morigaon;

    public Cachar getCachar() {
        return cachar;
    }

    public void setCachar(Cachar cachar) {
        this.cachar = cachar;
    }

    public KamrupMetropolitan getKamrupMetropolitan() {
        return kamrupMetropolitan;
    }

    public void setKamrupMetropolitan(KamrupMetropolitan kamrupMetropolitan) {
        this.kamrupMetropolitan = kamrupMetropolitan;
    }

    public Jorhat getJorhat() {
        return jorhat;
    }

    public void setJorhat(Jorhat jorhat) {
        this.jorhat = jorhat;
    }

    public Goalpara getGoalpara() {
        return goalpara;
    }

    public void setGoalpara(Goalpara goalpara) {
        this.goalpara = goalpara;
    }

    public Nalbari getNalbari() {
        return nalbari;
    }

    public void setNalbari(Nalbari nalbari) {
        this.nalbari = nalbari;
    }

    public SouthSalmaraMancachar getSouthSalmaraMancachar() {
        return southSalmaraMancachar;
    }

    public void setSouthSalmaraMancachar(SouthSalmaraMancachar southSalmaraMancachar) {
        this.southSalmaraMancachar = southSalmaraMancachar;
    }

    public Kamrup getKamrup() {
        return kamrup;
    }

    public void setKamrup(Kamrup kamrup) {
        this.kamrup = kamrup;
    }

    public Morigaon getMorigaon() {
        return morigaon;
    }

    public void setMorigaon(Morigaon morigaon) {
        this.morigaon = morigaon;
    }

}
