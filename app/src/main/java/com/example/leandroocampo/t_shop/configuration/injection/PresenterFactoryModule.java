package com.example.leandroocampo.t_shop.configuration.injection;

import com.example.leandroocampo.t_shop.common.presenter.factory.HomePresenterFactory;
import com.example.leandroocampo.t_shop.shop.presenter.factory.DetailShirtPresenterFactory;
import com.example.leandroocampo.t_shop.shop.presenter.factory.ListShirtPresenterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provides the components that create presenters.
 */
@SuppressWarnings("WeakerAccess")
@Module
public class PresenterFactoryModule {

    @Provides
    @Singleton
    HomePresenterFactory provideHomePresenterFactory() {
        return new HomePresenterFactory();
    }

    @Provides
    @Singleton
    ListShirtPresenterFactory provideListShirtPresenterFactory() {
        return new ListShirtPresenterFactory();
    }

    @Provides
    @Singleton
    DetailShirtPresenterFactory provideDetailShirtPresenterFactory() {
        return new DetailShirtPresenterFactory();
    }
}
