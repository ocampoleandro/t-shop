package com.example.leandroocampo.t_shop.configuration;

import com.example.leandroocampo.t_shop.configuration.injection.DaggerPresenterFactoryTestComponent;
import com.example.leandroocampo.t_shop.configuration.injection.PresenterFactoryComponent;
import com.example.leandroocampo.t_shop.configuration.injection.PresenterFactoryTestComponent;

public class DependencyInjectorTest implements Injector {

    private static DependencyInjectorTest instance;

    private PresenterFactoryTestComponent presenterFactoryComponent;

    public static DependencyInjectorTest getInstance() {
        if (instance == null) {
            synchronized (DependencyInjectorTest.class) {
                if (instance == null) {
                    instance = new DependencyInjectorTest();
                }
            }
        }
        return instance;
    }

    private DependencyInjectorTest() {
        presenterFactoryComponent = DaggerPresenterFactoryTestComponent.create();
    }

    /**
     * Return a {@link PresenterFactoryTestComponent} needed to inject dependencies
     *
     * @return a {@link PresenterFactoryTestComponent}
     */
    public PresenterFactoryComponent getPresenterFactoryComponent() {
        return presenterFactoryComponent;
    }
}
