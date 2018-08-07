package com.example.robert.newtpo2;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.robert.newtpo2.Utils.Dlog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView m_tvResult ;
    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private CStationTable table;

    private static final String KEY = "4d6b485562696f7437306c444a5a51";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btnLineNum);
        btn1.setOnClickListener(this);
        btn2 = (Button)findViewById(R.id.btnStationName);
        btn2.setOnClickListener(this);
        btn3 = (Button)findViewById(R.id.btnStationInfo);
        btn3.setOnClickListener(this);
        edit1 = (EditText)findViewById(R.id.editLineNum);
        edit2 = (EditText)findViewById(R.id.editStationName);
        edit3 = (EditText)findViewById(R.id.editStationLine);
        m_tvResult = (TextView) findViewById(R.id.result);

        //make stationInfo as table
        BaseApplication b = (BaseApplication) getApplication();

        table = b.getM_cStationTable();
    }

    public void onClick(View v) {
        CNetworkTask networkTask = new CNetworkTask();
        String strXMLData="";

        //FIXME : for debugging
        String strStationName = "삼성";
        String strStationLIne = "2";

        switch(v.getId()){
            case R.id.btnLineNum :
                String strLineNum = edit1.getText().toString();
                networkTask.setMethod("searchSTNBySubwayLineService");
                networkTask.setLineNum(strLineNum);
                try{
                    strXMLData = networkTask.execute().get();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnStationName :
                //String strStationName = edit2.getText().toString();
                strStationName = edit2.getText().toString();
                //String strStationLIne = edit3.getText().toString();

                /*
                CStationInfo stationInfo = new CStationInfo();
                stationInfo.setLineNum(strStationLIne);
                stationInfo.setStationName(strStationName);
                stationInfo.getStationInfo();
                */
                break;
            case R.id.btnStationInfo :
                //String strStationName = edit2.getText().toString();
                //String strStationLIne = edit3.getText().toString();
                networkTask.setMethod("searchArrivalInfoByIDService");
                networkTask.setStationCode(table.getStationCode(strStationName, strStationLIne));
                try{
                    strXMLData = networkTask.execute().get();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        m_tvResult.setText(strXMLData);
    }
}
