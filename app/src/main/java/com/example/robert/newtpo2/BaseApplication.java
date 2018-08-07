package com.example.robert.newtpo2;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class BaseApplication extends Application {
    public static boolean DEBUG;

    Context m_Context;
    Hashtable<String, CStation> m_dicStationDic;
    CStationTable m_cStationTable;

    @Override
    public void onCreate() {
        super.onCreate();
        this.m_Context = this;
        this.DEBUG = isDebuggable(this);
        this.m_cStationTable = new CStationTable(this);
    }

    /**
     * Returns whether currently debug mode is on or not.
     *
     * @param context
     * @return
     */
    private boolean isDebuggable(Context context) {
        boolean debuggable = true;

        PackageManager pm = context.getPackageManager();
        try {
            ApplicationInfo appinfo = pm.getApplicationInfo(context.getPackageName(), 0);
            debuggable = (0 != (appinfo.flags & ApplicationInfo.FLAG_DEBUGGABLE));
        } catch (PackageManager.NameNotFoundException e) {
            /* debuggable variable will remain false */
        }

        return debuggable;
    }

    public CStationTable getM_cStationTable() {
        return m_cStationTable;
    }
}