package com.example.robert.newtpo2;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by Robert on 2018-08-05.
 */
public class CStationTable extends Application {
    Context m_Context;
    Hashtable<String, CStation> m_dicStationDic;

    public void setContext(Context _Context){
        m_Context = _Context;
    }

    public void init(){
        m_dicStationDic = new Hashtable<String, CStation>();

        InputStream inputStream;
        AssetManager am = m_Context.getAssets();
        try{
            inputStream = am.open("stationInfo.json");
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            JSONArray jarray = new JSONArray(response.toString());

            for(int i=0; i < jarray.length(); i++){
                JSONObject jObject = jarray.getJSONObject(1);
                String stationName = jObject.getString("station_nm");
                String stationCode = jObject.getString("station_cd");
                String lineNum = jObject.getString("line_num");
                String frCode = jObject.getString("fr_code");

                m_dicStationDic.put(stationName+lineNum, new CStation(stationName, stationCode, lineNum, frCode));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFrCode(String strStationName, String strLineNum){
        return m_dicStationDic.get(strStationName+strLineNum).getFrCode();
    }
    public String getStationCode(String strStationName, String strLineNum){
        return m_dicStationDic.get(strStationName+strLineNum).getStationCode();
    }
}

class CStation{
    private String m_strStationName;
    private String m_strStationCode;
    private String m_strLineNum;
    private String m_strFrCode;

    public CStation(String strStationName, String strStationCode, String strLineNum, String strFrCode){
        m_strStationName = strStationName;
        m_strStationCode = strStationCode;
        m_strLineNum = strLineNum;
        m_strFrCode = strFrCode;
    }

    public String getStationName(){
        return m_strStationName;
    }
    public String getStationCode(){
        return m_strStationCode;
    }
    public String getLineNum(){
        return m_strLineNum;
    }
    public String getFrCode(){
        return m_strFrCode;
    }
}
