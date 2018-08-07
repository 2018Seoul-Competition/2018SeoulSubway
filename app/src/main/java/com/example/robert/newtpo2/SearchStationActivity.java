package com.example.robert.newtpo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Robert on 2018-08-05.
 */
public class SearchStationActivity extends AppCompatActivity implements Button.OnClickListener {
    private String m_strStart;
    private String m_strDest;

    private Button m_btnConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_btnConfirm = (Button)findViewById(R.id.stationNameConfirmBtn);
        m_btnConfirm.setOnClickListener(this);

        //make stationInfo as table
        BaseApplication b = (BaseApplication) getApplication();
        CStationTable table = b.getM_cStationTable();
    }

    public void onClick(View v) {
        switch(v.getId()){
            case R.id.stationNameConfirmBtn :
                TextView tv = (TextView) findViewById(R.id.showResult);
                break;
        }
    }
}
