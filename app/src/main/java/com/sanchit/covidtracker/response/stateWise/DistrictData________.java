
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData________ {

    @SerializedName("Jammu")
    @Expose
    private Jammu jammu;
    @SerializedName("Srinagar")
    @Expose
    private Srinagar srinagar;
    @SerializedName("Bandipore")
    @Expose
    private Bandipore bandipore;
    @SerializedName("Unknown")
    @Expose
    private Unknown____ unknown;
    @SerializedName("Rajouri")
    @Expose
    private Rajouri rajouri;
    @SerializedName("Badgam")
    @Expose
    private Badgam badgam;
    @SerializedName("Baramula")
    @Expose
    private Baramula baramula;
    @SerializedName("Shopian")
    @Expose
    private Shopian shopian;
    @SerializedName("Kashmir")
    @Expose
    private Kashmir kashmir;

    public Jammu getJammu() {
        return jammu;
    }

    public void setJammu(Jammu jammu) {
        this.jammu = jammu;
    }

    public Srinagar getSrinagar() {
        return srinagar;
    }

    public void setSrinagar(Srinagar srinagar) {
        this.srinagar = srinagar;
    }

    public Bandipore getBandipore() {
        return bandipore;
    }

    public void setBandipore(Bandipore bandipore) {
        this.bandipore = bandipore;
    }

    public Unknown____ getUnknown() {
        return unknown;
    }

    public void setUnknown(Unknown____ unknown) {
        this.unknown = unknown;
    }

    public Rajouri getRajouri() {
        return rajouri;
    }

    public void setRajouri(Rajouri rajouri) {
        this.rajouri = rajouri;
    }

    public Badgam getBadgam() {
        return badgam;
    }

    public void setBadgam(Badgam badgam) {
        this.badgam = badgam;
    }

    public Baramula getBaramula() {
        return baramula;
    }

    public void setBaramula(Baramula baramula) {
        this.baramula = baramula;
    }

    public Shopian getShopian() {
        return shopian;
    }

    public void setShopian(Shopian shopian) {
        this.shopian = shopian;
    }

    public Kashmir getKashmir() {
        return kashmir;
    }

    public void setKashmir(Kashmir kashmir) {
        this.kashmir = kashmir;
    }

}
