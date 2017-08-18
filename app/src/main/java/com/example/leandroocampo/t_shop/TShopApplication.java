package com.example.leandroocampo.t_shop;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.leandroocampo.t_shop.configuration.injection.DaggerPresenterFactoryComponent;
import com.example.leandroocampo.t_shop.configuration.injection.PresenterFactoryComponent;

public class TShopApplication extends Application {

    private static TShopApplication instance;
    protected PresenterFactoryComponent presenterFactoryComponent;

    public static TShopApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initInjectionComponent();
    }

    protected void initInjectionComponent() {
        presenterFactoryComponent = DaggerPresenterFactoryComponent.create();
    }

    /**
     * Use {@link PreferenceManager} to get a default {@link SharedPreferences}
     *
     * @return a {@link SharedPreferences}
     */
    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(this);
    }

    /**
     * Return a {@link PresenterFactoryComponent} needed to inject dependencies
     *
     * @return a {@link PresenterFactoryComponent}
     */
    public PresenterFactoryComponent getPresenterFactoryComponent() {
        return presenterFactoryComponent;
    }
}
