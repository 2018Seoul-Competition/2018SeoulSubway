package com.example.robert.newtpo2;

/**
 * Created by Robert on 2018-08-07.
 */
public class CStationInfo {
    private String m_strStationName;
    private String m_strLineNum;

    public void getStationInfo(){
        CNetworkTask networkTask = new CNetworkTask();
        String strXMLData="";

        //FIXME : for debugging
        m_strStationName = "삼성";
        m_strLineNum = "2";
        networkTask.setStationName(m_strStationName);
        networkTask.setMethod("realtimeStationArrival");
        try{
            strXMLData = networkTask.execute().get();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setStationName(String strStationName){
        m_strStationName = strStationName;
    }

    public void setLineNum(String strLineNum){
        m_strLineNum = strLineNum;
    }
}
