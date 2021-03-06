package com.example.robert.newtpo2;

import android.os.AsyncTask;

import com.example.robert.newtpo2.Utils.Dlog;

/**
 * Created by Robert on 2018-08-06.
 * get API from AsyncTask and return xml without modifying.
 * 1. construct CNetworktask
 * 2. setmethod and setvariables
 * 3. execute
 * 4. can get xml result data by execute().get()
 */
public class CNetworkTask extends AsyncTask<Void, Void, String> {
    private String m_strLineNum;
    private String m_strStationName;
    private String m_strStationCode;
    private String m_strFrCode;
    private String m_strMethod;

    public void setStationName(String strStationName){
        m_strStationName = strStationName;
    }

    public void setLineNum(String strLineNum){
        m_strLineNum = strLineNum;
    }

    public void setStationCode(String strStationCode){
        m_strStationCode = strStationCode;
    }

    public void setFrCode(String strFrCode){
        m_strFrCode = strFrCode;
    }

    public void setMethod(String strMethod){
        m_strMethod = strMethod;
    }

    protected void onPreExecute(){
    }

    @Override
    protected String doInBackground(Void... params) {
        String result = "";
        RestHTTPUrlConnection restHTTPUrlConnection = new RestHTTPUrlConnection();
        switch(m_strMethod){
            case "xmlTest":
                try {
                    result = restHTTPUrlConnection.xmlTest();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "searchSTNBySubwayLineService" :
                result = restHTTPUrlConnection.searchSTNBySubwayLineService(m_strLineNum);
                break;
            case "realtimeStationArrival" :
                result = restHTTPUrlConnection.realtimeStationArrival(m_strStationName);
                break;
            case "searchArrivalInfoByIDService" :
                result = restHTTPUrlConnection.searchArrivalInfoByIDService(m_strStationCode);
                break;
        }
        Dlog.i(result);
        return result;
    }

    protected void onPostExecute(String s){
    }
}
