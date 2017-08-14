package com.example.leandroocampo.t_shop.configuration.injection;

import com.example.leandroocampo.t_shop.shop.presenter.DetailShirtPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leandro on 14/08/17.
 */
@Singleton
@Component(modules = {ManagerModule.class})
public interface ManagerComponent {
    void inject(DetailShirtPresenter presenter);
}
