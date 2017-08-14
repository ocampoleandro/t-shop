package com.example.leandroocampo.t_shop.common.model.cart;

import com.example.leandroocampo.t_shop.common.model.Shirt;

import java.util.ArrayList;
import java.util.List;

/**
 * List of products selected by the user.
 */
public class Cart {

    private static Cart instance;

    //shirts only accessed by CartManager
    List<Shirt> persistentShirts;

    private Cart() {
        this.persistentShirts = new ArrayList<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            synchronized (Cart.class) {
                if (instance == null) {
                    instance = new Cart();
                }
            }
        }
        return instance;
    }

    public List<Shirt> getShirts() {
        return new ArrayList<>(persistentShirts);
    }

    public void clearShirts() {
        persistentShirts.clear();
    }
}
