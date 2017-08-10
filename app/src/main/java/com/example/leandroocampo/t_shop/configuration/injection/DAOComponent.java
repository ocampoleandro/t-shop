package com.example.leandroocampo.t_shop.configuration.injection;

import com.example.leandroocampo.t_shop.shop.presenter.ListShirtPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Inject the dependencies needed in each object.
 */
@Singleton
@Component(modules = {DAOModule.class})
public interface DAOComponent {
    void inject(ListShirtPresenter presenter);
}
