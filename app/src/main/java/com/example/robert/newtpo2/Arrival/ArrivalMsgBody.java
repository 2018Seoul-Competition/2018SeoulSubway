package com.example.robert.newtpo2.Arrival;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArrivalMsgBody {

    @SerializedName("itemList")
    @Expose
    private List<ArrivalItemList> arrivalItemList = null;

    public List<ArrivalItemList> getArrivalItemList() {
        return arrivalItemList;
    }

    public void setArrivalItemList(List<ArrivalItemList> arrivalItemList) {
        this.arrivalItemList = arrivalItemList;
    }

}