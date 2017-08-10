package com.example.leandroocampo.t_shop.common.manager;

import android.content.SharedPreferences;

import com.example.leandroocampo.t_shop.TShopApplication;

/**
 * Manager to manipulate {@link android.content.SharedPreferences}.
 */

public class SharedPreferenceManager {

    private SharedPreferences sharedPreferences;

    public SharedPreferenceManager() {
        sharedPreferences = TShopApplication.getInstance().getSharedPreferences();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public void putString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }
}
