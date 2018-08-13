package com.example.robert.newtpo2.Arrival;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArrivalServiceResult {

    @SerializedName("comMsgHeader")
    @Expose
    private String comMsgHeader;
    @SerializedName("msgHeader")
    @Expose
    private ArrivalMsgHeader arrivalMsgHeader;
    @SerializedName("msgBody")
    @Expose
    private ArrivalMsgBody arrivalMsgBody;

    public String getComMsgHeader() {
        return comMsgHeader;
    }

    public void setComMsgHeader(String comMsgHeader) {
        this.comMsgHeader = comMsgHeader;
    }

    public ArrivalMsgHeader getArrivalMsgHeader() {
        return arrivalMsgHeader;
    }

    public void setArrivalMsgHeader(ArrivalMsgHeader arrivalMsgHeader) {
        this.arrivalMsgHeader = arrivalMsgHeader;
    }

    public ArrivalMsgBody getArrivalMsgBody() {
        return arrivalMsgBody;
    }

    public void setArrivalMsgBody(ArrivalMsgBody arrivalMsgBody) {
        this.arrivalMsgBody = arrivalMsgBody;
    }
}