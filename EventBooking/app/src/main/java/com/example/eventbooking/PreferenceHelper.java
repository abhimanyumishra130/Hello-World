package com.example.eventbooking;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {


    public static final String PREF_SB  = "small database";
    public static SharedPreferences getInstance(Context context){
        return context.getSharedPreferences(PREF_SB,Context.MODE_PRIVATE);
    }

    public static void writeStringToPreference(Context context,String key, String data){
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putString(key,data);
        editor.apply();
    }

    public static void writeIntToPreference(Context context ,  String key, int data){
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putInt(key,data);
        editor.apply();
    }

    public static String getStringFromPreference(Context context, String key) {
        return getInstance(context).getString(key, null);
    }

    public static int getIntFromPreference(Context context, String key) {
        return getInstance(context).getInt(key, 0);
    }
}
