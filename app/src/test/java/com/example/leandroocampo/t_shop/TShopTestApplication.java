package com.example.leandroocampo.t_shop;

import com.example.leandroocampo.t_shop.configuration.DependencyInjectorTest;

public class TShopTestApplication extends TShopApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    protected void initializeInjector() {
        injector = DependencyInjectorTest.getInstance();
    }
}
