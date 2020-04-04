
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData___________ {

    @SerializedName("Amritsar")
    @Expose
    private Amritsar amritsar;
    @SerializedName("Shahid Bhagat Singh Nagar")
    @Expose
    private ShahidBhagatSinghNagar shahidBhagatSinghNagar;
    @SerializedName("S.A.S. Nagar")
    @Expose
    private SASNagar sASNagar;
    @SerializedName("Hoshiarpur")
    @Expose
    private Hoshiarpur hoshiarpur;
    @SerializedName("Jalandhar")
    @Expose
    private Jalandhar jalandhar;
    @SerializedName("Unknown")
    @Expose
    private Unknown______ unknown;
    @SerializedName("Ludhiana")
    @Expose
    private Ludhiana ludhiana;

    public Amritsar getAmritsar() {
        return amritsar;
    }

    public void setAmritsar(Amritsar amritsar) {
        this.amritsar = amritsar;
    }

    public ShahidBhagatSinghNagar getShahidBhagatSinghNagar() {
        return shahidBhagatSinghNagar;
    }

    public void setShahidBhagatSinghNagar(ShahidBhagatSinghNagar shahidBhagatSinghNagar) {
        this.shahidBhagatSinghNagar = shahidBhagatSinghNagar;
    }

    public SASNagar getSASNagar() {
        return sASNagar;
    }

    public void setSASNagar(SASNagar sASNagar) {
        this.sASNagar = sASNagar;
    }

    public Hoshiarpur getHoshiarpur() {
        return hoshiarpur;
    }

    public void setHoshiarpur(Hoshiarpur hoshiarpur) {
        this.hoshiarpur = hoshiarpur;
    }

    public Jalandhar getJalandhar() {
        return jalandhar;
    }

    public void setJalandhar(Jalandhar jalandhar) {
        this.jalandhar = jalandhar;
    }

    public Unknown______ getUnknown() {
        return unknown;
    }

    public void setUnknown(Unknown______ unknown) {
        this.unknown = unknown;
    }

    public Ludhiana getLudhiana() {
        return ludhiana;
    }

    public void setLudhiana(Ludhiana ludhiana) {
        this.ludhiana = ludhiana;
    }

}
