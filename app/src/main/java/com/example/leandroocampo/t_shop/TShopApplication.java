package com.example.leandroocampo.t_shop;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class TShopApplication extends Application {

    private static TShopApplication instance;

    public static TShopApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * Use {@link PreferenceManager} to get a default {@link SharedPreferences}
     *
     * @return a {@link SharedPreferences}
     */
    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(this);
    }
}
