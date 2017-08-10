package com.example.leandroocampo.t_shop;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.leandroocampo.t_shop.configuration.DependencyInjector;
import com.example.leandroocampo.t_shop.configuration.Injector;

public class TShopApplication extends Application {

    private static TShopApplication instance;
    protected Injector injector;

    public static TShopApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initializeInjector();
    }

    protected void initializeInjector() {
        injector = DependencyInjector.getInstance();
    }

    /**
     * Use {@link PreferenceManager} to get a default {@link SharedPreferences}
     *
     * @return a {@link SharedPreferences}
     */
    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(this);
    }

    public Injector getInjector() {
        return injector;
    }
}
