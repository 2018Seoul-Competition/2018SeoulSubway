package com.example.robert.newtpo2;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Robert on 2018-08-05.
 * Request HTTPUrlConnection and get api from seoul
 * have temp key for
 */
public class RestHTTPUrlConnection {
    //FIXME : temp key for debugging
    private String m_strTempKey = "4d6b485562696f7437306c444a5a51";

    //methods
    //FIXME : only need real time api.
    public String searchSTNBySubwayLineService(String strLineNUm){
        return request("http://openapi.seoul.go.kr:8088/"+m_strTempKey+"/xml/SearchSTNBySubwayLineService/0 /5/"+strLineNUm);
    }

    public String realtimeStationArrival(String strStationName){
        return request("http://swopenAPI.seoul.go.kr/api/subway/" + m_strTempKey + "/xml/realtimeStationArrival/0/5/" +strStationName);
    }


    public String request(String strUrl){
        HttpURLConnection urlConn = null;
        StringBuffer sbParams = new StringBuffer();
        try{
            URL url = new URL(strUrl);
            urlConn = (HttpURLConnection) url.openConnection();

            urlConn.setRequestMethod("GET");
            urlConn.setRequestProperty("Accept-Charset", "UTF-8"); // Accept-Charset 설정.
            urlConn.setRequestProperty("Context_Type", "application/x-www-form-urlencoded;cahrset=UTF-8");

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));

            // 출력물의 라인과 그 합에 대한 변수.
            String line;
            String page = "";

            // 라인을 받아와 합친다.
            while ((line = reader.readLine()) != null){
                page += line;
            }
            return page;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e){

        } finally {
            if(urlConn != null)
                urlConn.disconnect();
        }
        return null;
    }
}
