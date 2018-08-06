package com.example.robert.newtpo2;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    private static final String KEY = "4d6b485562696f7437306c444a5a51";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = (Button)findViewById(R.id.button3);
        btn3.setOnClickListener(this);

        m_tvResult = (TextView) findViewById(R.id.result);

        //make stationInfo as table
        CStationTable table = (CStationTable) getApplication();
        table.setContext(this);
        table.init();
    }

    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button1 :
                NetworkTask networkTask = new NetworkTask("");
                networkTask.execute();
                break;
            case R.id.button2 :
                break;
            case R.id.button3 :
                break;
        }
    }

    public class NetworkTask extends AsyncTask<Void, Void, String>{
        private String m_strUrl;

        public NetworkTask(String m_strUrl) {
            this.m_strUrl = m_strUrl;
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RestHTTPUrlConnection restHTTPUrlConnection = new RestHTTPUrlConnection();
            result = restHTTPUrlConnection.request(m_strUrl);
            return null;
        }
    }
}
