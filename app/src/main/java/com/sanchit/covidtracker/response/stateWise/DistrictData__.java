
package com.sanchit.covidtracker.response.stateWise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData__ {

    @SerializedName("Hyderabad")
    @Expose
    private Hyderabad hyderabad;
    @SerializedName("Karimnagar")
    @Expose
    private Karimnagar karimnagar;
    @SerializedName("Bhadradri Kothagudem")
    @Expose
    private BhadradriKothagudem bhadradriKothagudem;
    @SerializedName("Ranga Reddy")
    @Expose
    private RangaReddy rangaReddy;
    @SerializedName("Medchal Malkajgiri")
    @Expose
    private MedchalMalkajgiri medchalMalkajgiri;
    @SerializedName("Unknown")
    @Expose
    private Unknown_ unknown;

    public Hyderabad getHyderabad() {
        return hyderabad;
    }

    public void setHyderabad(Hyderabad hyderabad) {
        this.hyderabad = hyderabad;
    }

    public Karimnagar getKarimnagar() {
        return karimnagar;
    }

    public void setKarimnagar(Karimnagar karimnagar) {
        this.karimnagar = karimnagar;
    }

    public BhadradriKothagudem getBhadradriKothagudem() {
        return bhadradriKothagudem;
    }

    public void setBhadradriKothagudem(BhadradriKothagudem bhadradriKothagudem) {
        this.bhadradriKothagudem = bhadradriKothagudem;
    }

    public RangaReddy getRangaReddy() {
        return rangaReddy;
    }

    public void setRangaReddy(RangaReddy rangaReddy) {
        this.rangaReddy = rangaReddy;
    }

    public MedchalMalkajgiri getMedchalMalkajgiri() {
        return medchalMalkajgiri;
    }

    public void setMedchalMalkajgiri(MedchalMalkajgiri medchalMalkajgiri) {
        this.medchalMalkajgiri = medchalMalkajgiri;
    }

    public Unknown_ getUnknown() {
        return unknown;
    }

    public void setUnknown(Unknown_ unknown) {
        this.unknown = unknown;
    }

}
