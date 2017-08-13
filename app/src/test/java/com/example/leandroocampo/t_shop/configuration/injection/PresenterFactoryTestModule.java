package com.example.leandroocampo.t_shop.configuration.injection;

import com.example.leandroocampo.t_shop.common.presenter.factory.HomePresenterFactory;
import com.example.leandroocampo.t_shop.shop.presenter.factory.DetailShirtPresenterFactory;
import com.example.leandroocampo.t_shop.shop.presenter.factory.ListShirtPresenterFactory;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@SuppressWarnings("WeakerAccess")
@Module
public class PresenterFactoryTestModule {

    @Provides
    @Singleton
    HomePresenterFactory provideHomePresenterFactory() {
        return Mockito.mock(HomePresenterFactory.class);
    }

    @Provides
    @Singleton
    ListShirtPresenterFactory provideListShirtPresenterFactory() {
        return Mockito.mock(ListShirtPresenterFactory.class);
    }

    @Provides
    @Singleton
    DetailShirtPresenterFactory provideDetailShirtPresenterFactory() {
        return Mockito.mock(DetailShirtPresenterFactory.class);
    }
}
