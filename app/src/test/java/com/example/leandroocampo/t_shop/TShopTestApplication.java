package com.example.leandroocampo.t_shop;

import com.example.leandroocampo.t_shop.configuration.injection.DaggerPresenterFactoryTestComponent;

public class TShopTestApplication extends TShopApplication {

    @Override
    protected void initInjectionComponent() {
        presenterFactoryComponent = DaggerPresenterFactoryTestComponent.create();
    }
}
