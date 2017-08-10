package com.example.leandroocampo.t_shop.configuration;

import com.example.leandroocampo.t_shop.configuration.injection.PresenterFactoryComponent;

/**
 * Injector of dependencies.
 */

public interface Injector {

    /**
     * Return an injector component that injects {@link com.example.leandroocampo.t_shop.common.presenter.BasePresenter}
     * instances
     * @return a {@link PresenterFactoryComponent}
     */
    PresenterFactoryComponent getPresenterFactoryComponent();
}
