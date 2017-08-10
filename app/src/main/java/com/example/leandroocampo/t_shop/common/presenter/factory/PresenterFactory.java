package com.example.leandroocampo.t_shop.common.presenter.factory;

import android.support.annotation.Nullable;

import com.example.leandroocampo.t_shop.common.presenter.BasePresenter;
import com.example.leandroocampo.t_shop.common.provider.ParamsProvider;

/**
 * Creates a Presenter object.
 *
 * @param <T> presenter type
 */
public interface PresenterFactory<T extends BasePresenter> {

    T create(@Nullable ParamsProvider bundleProvider);
}
