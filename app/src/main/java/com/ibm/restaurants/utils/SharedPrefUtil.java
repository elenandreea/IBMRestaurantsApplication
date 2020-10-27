package com.ibm.restaurants.utils;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPrefUtil {

    private static final String TYPE = "FAVORITE";
    private final SharedPreferences prefs;

    public SharedPrefUtil(Context context) {
        prefs = context.getSharedPreferences(TYPE, Context.MODE_PRIVATE);
    }

    public boolean isFavorite(String restaurantTitle) {
        return prefs.getBoolean(restaurantTitle, false);
    }

    public void changeFavorite(String restaurantTitle, boolean isFavorite) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(restaurantTitle, isFavorite).apply();
    }
}
