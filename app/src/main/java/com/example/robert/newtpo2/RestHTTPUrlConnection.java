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
        return request("http://openapi.seoul.go.kr:8088/"+m_strTempKey+"/xml/SearchSTNBySubwayLineService/0/5/"+strLineNUm);
    }

    //FIXME : have to get xml data and change the value of request url
    //        change key to sample because of unknown error
    public String realtimeStationArrival(String strStationName){
        //return request("http://swopenAPI.seoul.go.kr/api/subway/" + m_strTempKey + "/xml/realtimeStationArrival/0/5/" +strStationName);
        return request("http://swopenAPI.seoul.go.kr/api/subway/sample/xml/realtimeStationArrival/0/5/" +strStationName);
    }

    public String searchArrivalInfoByIDService(String strStationCode){
        //상행 1
        String strUproute = request("http://openAPI.seoul.go.kr:8088/"+m_strTempKey + "/xml/SearchArrivalInfoByIDService/0/5/"+ strStationCode + "/1/3/");
        //하행 2
        String strDwonroute = request("http://openAPI.seoul.go.kr:8088/"+m_strTempKey + "/xml/SearchArrivalInfoByIDService/0/5/"+ strStationCode + "/2/3/ ");
        return strUproute + strDwonroute;
    }


    public String request(String strUrl){
        HttpURLConnection urlConn = null;
        StringBuffer sbParams = new StringBuffer();
        try{
            URL url = new URL(strUrl);
            urlConn = (HttpURLConnection) url.openConnection();

            urlConn.setRequestMethod("GET");
            urlConn.setRequestProperty("Accept-Charset", "UTF-8"); // Accept-Charset 설정.
            urlConn.setRequestProperty("Context_Type", "application/x-www-form-urlencoded;charset=UTF-8");

            //FIXME : have error when using realtime api
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

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
            e.printStackTrace();
        } finally {
            if(urlConn != null)
                urlConn.disconnect();
        }
        return null;
    }
}
