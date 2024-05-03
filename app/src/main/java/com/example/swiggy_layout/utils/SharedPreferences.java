package com.example.swiggy_layout.utils;

import android.content.Context;

public class SharedPreferences {

    public static void saveLogin(Context context,String mobile)
    {
        android.content.SharedPreferences sharedPreferences=context.getSharedPreferences("login_details",Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("isLoggedIn",true);
        editor.putString("mobile",mobile);
        editor.apply();
    }

    public static boolean isLoggedIn(Context context)
    {
        android.content.SharedPreferences preferences=context.getSharedPreferences("login_details",Context.MODE_PRIVATE);
        boolean isLogin=preferences.getBoolean("isLoggedIn",false);
        return isLogin;
    }

    public  static String getNumber(Context context)
    {
        android.content.SharedPreferences preferences=context.getSharedPreferences("login_details",Context.MODE_PRIVATE);
        String isLogin=preferences.getString("mobile","");
        return isLogin;
    }


}
