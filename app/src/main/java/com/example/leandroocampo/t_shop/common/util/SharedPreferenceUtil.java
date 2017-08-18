package com.example.leandroocampo.t_shop.common.util;

import android.content.SharedPreferences;

import com.example.leandroocampo.t_shop.TShopApplication;

/**
 * Manager to manipulate {@link android.content.SharedPreferences}.
 */

public class SharedPreferenceUtil {

    private SharedPreferences sharedPreferences;

    public SharedPreferenceUtil() {
        sharedPreferences = TShopApplication.getInstance().getSharedPreferences();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public void putString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }
}
