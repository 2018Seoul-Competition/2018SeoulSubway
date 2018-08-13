package com.example.robert.newtpo2.Arrival;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ArrivalItemList {

    @SerializedName("stopFlag")
    @Expose
    private int stopFlag;
    @SerializedName("isFullFlag")
    @Expose
    private int isFullFlag;
    @SerializedName("rtDist")
    @Expose
    private int rtDist;
    @SerializedName("lastStnId")
    @Expose
    private int lastStnId;
    @SerializedName("plainNo")
    @Expose
    private String plainNo;
    @SerializedName("sectDist")
    @Expose
    private double sectDist;
    @SerializedName("fullSectDist")
    @Expose
    private double fullSectDist;
    @SerializedName("nextStId")
    @Expose
    private int nextStId;
    @SerializedName("nextStTm")
    @Expose
    private int nextStTm;
    @SerializedName("sectionId")
    @Expose
    private int sectionId;
    @SerializedName("posX")
    @Expose
    private double posX;
    @SerializedName("posY")
    @Expose
    private double posY;
    @SerializedName("sectOrd")
    @Expose
    private int sectOrd;
    @SerializedName("dataTm")
    @Expose
    private float dataTm;
    @SerializedName("lastStTm")
    @Expose
    private int lastStTm;
    @SerializedName("islastyn")
    @Expose
    private int islastyn;
    @SerializedName("trnstnid")
    @Expose
    private int trnstnid;
    @SerializedName("vehId")
    @Expose
    private int vehId;
    @SerializedName("congetion")
    @Expose
    private int congetion;
    @SerializedName("busType")
    @Expose
    private int busType;
    @SerializedName("gpsX")
    @Expose
    private double gpsX;
    @SerializedName("isrunyn")
    @Expose
    private int isrunyn;
    @SerializedName("gpsY")
    @Expose
    private double gpsY;

    public int getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(int stopFlag) {
        this.stopFlag = stopFlag;
    }

    public int getIsFullFlag() {
        return isFullFlag;
    }

    public void setIsFullFlag(int isFullFlag) {
        this.isFullFlag = isFullFlag;
    }

    public int getRtDist() {
        return rtDist;
    }

    public void setRtDist(int rtDist) {
        this.rtDist = rtDist;
    }

    public int getLastStnId() {
        return lastStnId;
    }

    public void setLastStnId(int lastStnId) {
        this.lastStnId = lastStnId;
    }

    public String getPlainNo() {
        return plainNo;
    }

    public void setPlainNo(String plainNo) {
        this.plainNo = plainNo;
    }

    public double getSectDist() {
        return sectDist;
    }

    public void setSectDist(double sectDist) {
        this.sectDist = sectDist;
    }

    public double getFullSectDist() {
        return fullSectDist;
    }

    public void setFullSectDist(double fullSectDist) {
        this.fullSectDist = fullSectDist;
    }

    public int getNextStId() {
        return nextStId;
    }

    public void setNextStId(int nextStId) {
        this.nextStId = nextStId;
    }

    public int getNextStTm() {
        return nextStTm;
    }

    public void setNextStTm(int nextStTm) {
        this.nextStTm = nextStTm;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public int getSectOrd() {
        return sectOrd;
    }

    public void setSectOrd(int sectOrd) {
        this.sectOrd = sectOrd;
    }

    public float getDataTm() {
        return dataTm;
    }

    public void setDataTm(float dataTm) {
        this.dataTm = dataTm;
    }

    public int getLastStTm() {
        return lastStTm;
    }

    public void setLastStTm(int lastStTm) {
        this.lastStTm = lastStTm;
    }

    public int getIslastyn() {
        return islastyn;
    }

    public void setIslastyn(int islastyn) {
        this.islastyn = islastyn;
    }

    public int getTrnstnid() {
        return trnstnid;
    }

    public void setTrnstnid(int trnstnid) {
        this.trnstnid = trnstnid;
    }

    public int getVehId() {
        return vehId;
    }

    public void setVehId(int vehId) {
        this.vehId = vehId;
    }

    public int getCongetion() {
        return congetion;
    }

    public void setCongetion(int congetion) {
        this.congetion = congetion;
    }

    public int getBusType() {
        return busType;
    }

    public void setBusType(int busType) {
        this.busType = busType;
    }

    public double getGpsX() {
        return gpsX;
    }

    public void setGpsX(double gpsX) {
        this.gpsX = gpsX;
    }

    public int getIsrunyn() {
        return isrunyn;
    }

    public void setIsrunyn(int isrunyn) {
        this.isrunyn = isrunyn;
    }

    public double getGpsY() {
        return gpsY;
    }

    public void setGpsY(double gpsY) {
        this.gpsY = gpsY;
    }

}