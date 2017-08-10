package com.example.leandroocampo.t_shop.configuration.injection;

import com.example.leandroocampo.t_shop.common.ui.activity.HomeActivityTest;
import com.example.leandroocampo.t_shop.shop.ui.fragment.ListShirtFragmentTest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Inject the dependencies needed in each object.
 */
@Singleton
@Component(modules = {PresenterFactoryTestModule.class})
public interface PresenterFactoryTestComponent extends PresenterFactoryComponent {
    void inject(HomeActivityTest activity);

    void inject(ListShirtFragmentTest fragment);
}
