package com.sanchit.covidtracker.ApplicationClass;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;


import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;

import com.facebook.stetho.BuildConfig;
import com.facebook.stetho.Stetho;
import com.sanchit.covidtracker.Utils.PreferencesUtil;

public class CovidTrackerApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        PreferencesUtil.loadPreferences();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Context getContext() {
        return context;
    }

    public void setContext(Context context)  {
        this.context = context;
    }
}
