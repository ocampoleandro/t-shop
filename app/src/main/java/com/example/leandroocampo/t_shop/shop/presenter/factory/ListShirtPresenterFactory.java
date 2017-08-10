package com.example.leandroocampo.t_shop.shop.presenter.factory;

import android.support.annotation.Nullable;

import com.example.leandroocampo.t_shop.common.presenter.factory.PresenterFactory;
import com.example.leandroocampo.t_shop.common.provider.ParamsProvider;
import com.example.leandroocampo.t_shop.shop.presenter.ListShirtPresenter;

/**
 * Created by leandro.ocampo on 8/10/17.
 */

public class ListShirtPresenterFactory implements PresenterFactory<ListShirtPresenter> {
    @Override
    public ListShirtPresenter create(@Nullable ParamsProvider bundleProvider) {
        return new ListShirtPresenter();
    }
}
