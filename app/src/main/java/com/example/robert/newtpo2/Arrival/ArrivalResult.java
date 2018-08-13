package com.example.robert.newtpo2.Arrival;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArrivalResult {

    @SerializedName("ServiceResult")
    @Expose
    private ArrivalServiceResult arrivalServiceResult;

    public ArrivalServiceResult getArrivalServiceResult() {
        return arrivalServiceResult;
    }

    public void setArrivalServiceResult(ArrivalServiceResult arrivalServiceResult) {
        this.arrivalServiceResult = arrivalServiceResult;
    }
}