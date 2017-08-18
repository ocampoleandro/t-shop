package com.example.leandroocampo.t_shop.shop.presenter;

import com.example.leandroocampo.t_shop.common.model.Shirt;
import com.example.leandroocampo.t_shop.common.model.cart.CartManager;
import com.example.leandroocampo.t_shop.common.presenter.BasePresenter;
import com.example.leandroocampo.t_shop.common.provider.ParamsProvider;
import com.example.leandroocampo.t_shop.shop.view.DetailShirtView;

public class DetailShirtPresenter extends BasePresenter<DetailShirtView> implements CartManager.Listener {

    public static final String SHIRT_PARAM = "SHIRT_PARAM";

    private CartManager cartManager;

    private Shirt shirt;

    public DetailShirtPresenter(CartManager cartManager, ParamsProvider bundleProvider) {
        this.cartManager = cartManager;
        shirt = bundleProvider.getParcelable(SHIRT_PARAM);
    }

    @Override
    public void onSaveInstanceState(ParamsProvider bundleProvider) {
        bundleProvider.putParcelable(SHIRT_PARAM, shirt);
    }

    public Shirt onShirtNeeded() {
        return shirt;
    }

    public void onShirtAddedToCart() {
        cartManager.addShirt(shirt, this);
    }

    @Override
    public void outOfStock() {
        view.showNoEnoughStockMessage();
    }
}
