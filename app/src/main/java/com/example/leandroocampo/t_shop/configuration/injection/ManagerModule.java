package com.example.leandroocampo.t_shop.configuration.injection;

import com.example.leandroocampo.t_shop.common.model.cart.Cart;
import com.example.leandroocampo.t_shop.common.model.cart.CartManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leandro on 14/08/17.
 */
@SuppressWarnings("WeakerAccess")
@Module
public class ManagerModule {

    @Provides
    @Singleton
    Cart provideCart() {
        return new Cart();
    }

    @Provides
    @Singleton
    CartManager provideCartManager(Cart cart) {
        return new CartManager(cart);
    }
}
