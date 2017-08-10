package com.example.leandroocampo.t_shop.configuration.injection;

import com.example.leandroocampo.t_shop.common.ui.activity.HomeActivity;
import com.example.leandroocampo.t_shop.shop.ui.fragment.ListShirtFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Inject the dependencies needed in each object.
 */
@Singleton
@Component(modules = {PresenterFactoryModule.class})
public interface PresenterFactoryComponent {
    void inject(HomeActivity activity);

    void inject(ListShirtFragment fragment);
}
