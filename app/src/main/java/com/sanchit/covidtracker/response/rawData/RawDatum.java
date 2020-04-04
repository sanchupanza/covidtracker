package com.sanchit.covidtracker.response.rawData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class RawDatum {
    @SerializedName("agebracket")
    @Expose
    private String agebracket;
    @SerializedName("backupnotes")
    @Expose
    private String backupnotes;
    @SerializedName("contractedfromwhichpatientsuspected")
    @Expose
    private String contractedfromwhichpatientsuspected;
    @SerializedName("currentstatus")
    @Expose
    private String currentstatus;
    @SerializedName("dateannounced")
    @Expose
    private String dateannounced;
    @SerializedName("detectedcity")
    @Expose
    private String detectedcity;
    @SerializedName("detecteddistrict")
    @Expose
    private String detecteddistrict;
    @SerializedName("detectedstate")
    @Expose
    private String detectedstate;
    @SerializedName("estimatedonsetdate")
    @Expose
    private String estimatedonsetdate;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("patientnumber")
    @Expose
    private String patientnumber;
    @SerializedName("source1")
    @Expose
    private String source1;
    @SerializedName("source2")
    @Expose
    private String source2;
    @SerializedName("source3")
    @Expose
    private String source3;
    @SerializedName("statecode")
    @Expose
    private String statecode;
    @SerializedName("statepatientnumber")
    @Expose
    private String statepatientnumber;
    @SerializedName("statuschangedate")
    @Expose
    private String statuschangedate;
    @SerializedName("typeoftransmission")
    @Expose
    private String typeoftransmission;

    public String getAgebracket() {
        return agebracket;
    }

    public void setAgebracket(String agebracket) {
        this.agebracket = agebracket;
    }

    public String getBackupnotes() {
        return backupnotes;
    }

    public void setBackupnotes(String backupnotes) {
        this.backupnotes = backupnotes;
    }

    public String getContractedfromwhichpatientsuspected() {
        return contractedfromwhichpatientsuspected;
    }

    public void setContractedfromwhichpatientsuspected(String contractedfromwhichpatientsuspected) {
        this.contractedfromwhichpatientsuspected = contractedfromwhichpatientsuspected;
    }

    public String getCurrentstatus() {
        return currentstatus;
    }

    public void setCurrentstatus(String currentstatus) {
        this.currentstatus = currentstatus;
    }

    public String getDateannounced() {
        return dateannounced;
    }

    public void setDateannounced(String dateannounced) {
        this.dateannounced = dateannounced;
    }

    public String getDetectedcity() {
        return detectedcity;
    }

    public void setDetectedcity(String detectedcity) {
        this.detectedcity = detectedcity;
    }

    public String getDetecteddistrict() {
        return detecteddistrict;
    }

    public void setDetecteddistrict(String detecteddistrict) {
        this.detecteddistrict = detecteddistrict;
    }

    public String getDetectedstate() {
        return detectedstate;
    }

    public void setDetectedstate(String detectedstate) {
        this.detectedstate = detectedstate;
    }

    public String getEstimatedonsetdate() {
        return estimatedonsetdate;
    }

    public void setEstimatedonsetdate(String estimatedonsetdate) {
        this.estimatedonsetdate = estimatedonsetdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPatientnumber() {
        return patientnumber;
    }

    public void setPatientnumber(String patientnumber) {
        this.patientnumber = patientnumber;
    }

    public String getSource1() {
        return source1;
    }

    public void setSource1(String source1) {
        this.source1 = source1;
    }

    public String getSource2() {
        return source2;
    }

    public void setSource2(String source2) {
        this.source2 = source2;
    }

    public String getSource3() {
        return source3;
    }

    public void setSource3(String source3) {
        this.source3 = source3;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getStatepatientnumber() {
        return statepatientnumber;
    }

    public void setStatepatientnumber(String statepatientnumber) {
        this.statepatientnumber = statepatientnumber;
    }

    public String getStatuschangedate() {
        return statuschangedate;
    }

    public void setStatuschangedate(String statuschangedate) {
        this.statuschangedate = statuschangedate;
    }

    public String getTypeoftransmission() {
        return typeoftransmission;
    }

    public void setTypeoftransmission(String typeoftransmission) {
        this.typeoftransmission = typeoftransmission;
    }
}
