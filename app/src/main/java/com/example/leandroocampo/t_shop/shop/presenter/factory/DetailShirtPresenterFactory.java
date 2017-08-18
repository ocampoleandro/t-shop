package com.example.leandroocampo.t_shop.shop.presenter.factory;

import android.support.annotation.Nullable;

import com.example.leandroocampo.t_shop.common.model.cart.CartManager;
import com.example.leandroocampo.t_shop.common.presenter.factory.PresenterFactory;
import com.example.leandroocampo.t_shop.common.provider.ParamsProvider;
import com.example.leandroocampo.t_shop.shop.presenter.DetailShirtPresenter;

/**
 * Created by leandro on 13/08/17.
 */

public class DetailShirtPresenterFactory implements PresenterFactory<DetailShirtPresenter> {

    private CartManager cartManager;

    public DetailShirtPresenterFactory(CartManager cartManager) {
        this.cartManager = cartManager;
    }

    @Override
    public DetailShirtPresenter create(@Nullable ParamsProvider bundleProvider) {
        return new DetailShirtPresenter(cartManager, bundleProvider);
    }
}
