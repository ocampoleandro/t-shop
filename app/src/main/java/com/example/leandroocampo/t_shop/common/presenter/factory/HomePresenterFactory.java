package com.example.leandroocampo.t_shop.common.presenter.factory;

import android.support.annotation.Nullable;

import com.example.leandroocampo.t_shop.common.presenter.HomePresenter;
import com.example.leandroocampo.t_shop.common.provider.ParamsProvider;

/**
 * Creates {@link HomePresenter}
 */

public class HomePresenterFactory implements PresenterFactory<HomePresenter> {
    @Override
    public HomePresenter create(@Nullable ParamsProvider bundleProvider) {
        return new HomePresenter();
    }
}
