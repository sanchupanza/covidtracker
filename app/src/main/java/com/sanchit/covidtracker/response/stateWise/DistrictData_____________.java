
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData_____________ {

    @SerializedName("Dehradun")
    @Expose
    private Dehradun dehradun;
    @SerializedName("Pauri Garhwal")
    @Expose
    private PauriGarhwal pauriGarhwal;
    @SerializedName("Udham Singh Nagar")
    @Expose
    private UdhamSinghNagar udhamSinghNagar;
    @SerializedName("Unknown")
    @Expose
    private Unknown_______ unknown;

    public Dehradun getDehradun() {
        return dehradun;
    }

    public void setDehradun(Dehradun dehradun) {
        this.dehradun = dehradun;
    }

    public PauriGarhwal getPauriGarhwal() {
        return pauriGarhwal;
    }

    public void setPauriGarhwal(PauriGarhwal pauriGarhwal) {
        this.pauriGarhwal = pauriGarhwal;
    }

    public UdhamSinghNagar getUdhamSinghNagar() {
        return udhamSinghNagar;
    }

    public void setUdhamSinghNagar(UdhamSinghNagar udhamSinghNagar) {
        this.udhamSinghNagar = udhamSinghNagar;
    }

    public Unknown_______ getUnknown() {
        return unknown;
    }

    public void setUnknown(Unknown_______ unknown) {
        this.unknown = unknown;
    }

}
