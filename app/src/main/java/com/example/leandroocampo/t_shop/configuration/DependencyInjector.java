package com.example.leandroocampo.t_shop.configuration;

import com.example.leandroocampo.t_shop.configuration.injection.DAOComponent;
import com.example.leandroocampo.t_shop.configuration.injection.DaggerDAOComponent;
import com.example.leandroocampo.t_shop.configuration.injection.DaggerPresenterFactoryComponent;
import com.example.leandroocampo.t_shop.configuration.injection.PresenterFactoryComponent;

/**
 * Initialize components needed to inject dependencies.
 */

public class DependencyInjector implements Injector {

    private static DependencyInjector instance;

    private PresenterFactoryComponent presenterFactoryComponent;
    private DAOComponent daoComponent;

    public static DependencyInjector getInstance() {
        if (instance == null) {
            synchronized (DependencyInjector.class) {
                if (instance == null) {
                    instance = new DependencyInjector();
                }
            }
        }
        return instance;
    }

    private DependencyInjector() {
        presenterFactoryComponent = DaggerPresenterFactoryComponent.create();
        daoComponent = DaggerDAOComponent.create();
    }

    /**
     * Return a {@link PresenterFactoryComponent} needed to inject dependencies
     *
     * @return a {@link PresenterFactoryComponent}
     */
    public PresenterFactoryComponent getPresenterFactoryComponent() {
        return presenterFactoryComponent;
    }

    /**
     * Return a {@link DAOComponent} needed to inject dependencies
     *
     * @return a {@link DAOComponent}
     */
    public DAOComponent getDaoComponent() {
        return daoComponent;
    }
}
