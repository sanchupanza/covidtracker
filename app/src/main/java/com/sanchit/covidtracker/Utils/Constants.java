package com.sanchit.covidtracker.Utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.core.content.ContextCompat;

import com.sanchit.covidtracker.ApplicationClass.CovidTrackerApp;

import org.ocpsoft.prettytime.PrettyTime;

import java.util.Date;

public class Constants {
    public static final String NF = "NF";
    public static final String SUCCESS = "success";


    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) CovidTrackerApp.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public static void darkenStatusBar(Activity activity, int color) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

  /*          activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
*/
            activity.getWindow().setStatusBarColor(
                    darkenColor(
                            ContextCompat.getColor(activity, color)));
        }

    }

    public static void darkenBottomBar(Activity activity, int color) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {



            activity.getWindow().setNavigationBarColor(
                    darkenColor(
                            ContextCompat.getColor(activity, color)));
        }

    }


    public static String getTime(long timeStamp)
    {
        String date = new java.text.SimpleDateFormat("dd-MM-yyyy hh:mm aa").format(new java.util.Date (timeStamp*1000));
        return date;
    }

    private static int darkenColor(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.8f;
        return Color.HSVToColor(hsv);
    }


    public static int getSmallIndex(int[] a) {
        int min = a[0];
        int index=0;

        for(int i = 0; i < a.length; i++)
        {
            if(min > a[i])
            {
                min = a[i];
                index=i;
            }
        }

        return index;
    }

    public static String getTimeAgo(Long time) {
        PrettyTime p = new PrettyTime();
        String newDate = p.format(new Date(time *1000));
        return  newDate;
    }
}
