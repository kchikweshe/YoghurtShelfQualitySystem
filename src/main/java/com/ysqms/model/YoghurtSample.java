package com.ysqms.model;


public class YoghurtSample {


    private Integer id;
    private Double criticalTemperature;
    private Double temperature;
    private Float Bostwick_Value;
    private Double totalSolids;
    private Double ph;
    private Integer shelfTime;
    private Double shelfQualityLoss, sqrgv, sqrcv, labbqPercent, ffiPercent, phPercent;

    public Double getShelfQualityLoss() {
        return shelfQualityLoss;
    }

    public void setShelfQualityLoss(Double shelfQualityLoss) {
        this.shelfQualityLoss = shelfQualityLoss;
    }

    public Double getSqrgv() {
        return sqrgv;
    }

    public void setSqrgv(Double sqrgv) {
        this.sqrgv = sqrgv;
    }

    public Double getSqrcv() {
        return sqrcv;
    }

    public void setSqrcv(Double sqrcv) {
        this.sqrcv = sqrcv;
    }

    public Double getLabbqPercent() {
        return labbqPercent;
    }

    public void setLabbqPercent(Double labbqPercent) {
        this.labbqPercent = labbqPercent;
    }

    public Double getFfiPercent() {
        return ffiPercent;
    }

    public void setFfiPercent(Double ffiPercent) {
        this.ffiPercent = ffiPercent;
    }

    public Double getPhPercent() {
        return phPercent;
    }

    public void setPhPercent(Double phPercent) {
        this.phPercent = phPercent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCriticalTemperature() {
        return criticalTemperature;
    }

    public void setCriticalTemperature(Double criticalTemperature) {
        this.criticalTemperature = criticalTemperature;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Float getBostwick_Value() {
        return Bostwick_Value;
    }

    public void setBostwick_Value(Float bostwick_Value) {
        Bostwick_Value = bostwick_Value;
    }

    public Double getTotalSolids() {
        return totalSolids;
    }

    public void setTotalSolids(Double totalSolids) {
        this.totalSolids = totalSolids;
    }

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    public Integer getShelfTime() {
        return shelfTime;
    }


    public void setShelfTime(Integer shelfTime) {
        this.shelfTime = shelfTime;
    }
}
