package com.example.and03unit_2c_2;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    public static final String KEY = "small database";
    public static SharedPreferences getDataPreference(Context context){
        return context.getSharedPreferences(KEY,Context.MODE_PRIVATE);
    }

    public static void writeToPreference(Context context,String key, String value){
        SharedPreferences.Editor editor =getDataPreference(context).edit();
        editor.putString(key, value);
        editor.apply();
    }
    public static String getFormPreference(Context context , String key){
        return getDataPreference(context).getString(key,null);
    }

    public static void booleanToPreference(Context context,String key, boolean value){
        SharedPreferences.Editor editor = getDataPreference(context).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public  static boolean booleanFromPreference(Context context , String key){
        return getDataPreference(context).getBoolean(key,false);
    }
}
