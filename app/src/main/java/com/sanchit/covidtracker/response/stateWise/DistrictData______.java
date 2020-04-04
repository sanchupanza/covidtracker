
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData______ {

    @SerializedName("Leh")
    @Expose
    private Leh leh;
    @SerializedName("Kargil")
    @Expose
    private Kargil kargil;

    public Leh getLeh() {
        return leh;
    }

    public void setLeh(Leh leh) {
        this.leh = leh;
    }

    public Kargil getKargil() {
        return kargil;
    }

    public void setKargil(Kargil kargil) {
        this.kargil = kargil;
    }

}
