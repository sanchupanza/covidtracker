package com.sanchit.covidtracker.Utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.sanchit.covidtracker.ApplicationClass.CovidTrackerApp;

public class PreferencesUtil {

    private static SharedPreferences preferences =
            PreferenceManager.getDefaultSharedPreferences(CovidTrackerApp.getContext());

    private static boolean loggedIn;
    private static String fcmToken;


    public static void loadPreferences() {

        loggedIn = preferences.getBoolean("loggedIn", false);
        fcmToken = preferences.getString("fcm",fcmToken);

    }


    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        PreferencesUtil.loggedIn = loggedIn;
        preferences.edit().putBoolean("loggedIn", loggedIn).apply();
    }

    public static String getFcmToken() {
        return fcmToken;
    }

    public static void setFcmToken(String fcmToken) {
        PreferencesUtil.fcmToken = fcmToken;
        preferences.edit().putString("fcm",fcmToken).apply();
    }

    public static void clearPrefs() {

        preferences.edit().clear().apply();

        preferences.edit().putBoolean("loggedIn", false).apply();
        preferences.edit().putString("user_entity", null).apply();
        preferences.edit().putString("access_token", Constants.NF).apply();

        loadPreferences();
    }


}
