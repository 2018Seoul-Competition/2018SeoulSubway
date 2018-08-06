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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
        table = (CStationTable) getApplication();
        table.setContext(this);
        table.init();
    }

    public void onClick(View v) {
        CNetworkTask networkTask = new CNetworkTask();

        //FIXME : for debugging
        String strStationName = "삼성";
        String strStationLIne = "2";

        switch(v.getId()){
            case R.id.btnLineNum :
                String strLineNum = edit1.getText().toString();
                networkTask.setMethod("searchSTNBySubwayLineService");
                networkTask.setLineNum(strLineNum);
                networkTask.execute();
                break;
            case R.id.btnStationName :
                //String strStationName = edit2.getText().toString();
                //String strStationLIne = edit3.getText().toString();
                networkTask.setMethod("realtimeStationArrival");
                networkTask.setStationCode(table.getStationCode(strStationName, strStationLIne));
                networkTask.execute();
                break;
            case R.id.btnStationInfo :
                //String strStationName = edit2.getText().toString();
                //String strStationLIne = edit3.getText().toString();
                networkTask.setMethod("searchArrivalInfoByIDService");
                networkTask.setStationCode(table.getStationCode(strStationName, strStationLIne));
                networkTask.execute();
                break;
        }
    }

    public class NetworkTask extends AsyncTask<Void, Void, String>{
        private String m_strLineNum;
        private String m_strStationName;
        private String m_strStationCode;
        private String m_strFrCode;
        private String m_strMethod;

       private void setStationName(String strStationName){
           m_strStationName = strStationName;
       }

        private void setLineNum(String strLineNum){
            m_strLineNum = strLineNum;
        }

        private void setStationCode(String strStationCode){
            m_strStationCode = strStationCode;
        }

        private void setFrCode(String strFrCode){
            m_strFrCode = strFrCode;
        }

        private void setMethod(String strMethod){
            m_strMethod = strMethod;
        }

        @Override
        protected String doInBackground(Void... params) {
            String result = "";
            RestHTTPUrlConnection restHTTPUrlConnection = new RestHTTPUrlConnection();
            switch(m_strMethod){
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
            return result;
        }

        protected void onPostExecute(String s){
            m_tvResult.setText(s);
        }
    }
}
