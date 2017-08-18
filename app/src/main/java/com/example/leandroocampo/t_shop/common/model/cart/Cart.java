package com.example.leandroocampo.t_shop.common.model.cart;

import com.example.leandroocampo.t_shop.common.model.Shirt;

import java.util.ArrayList;
import java.util.List;

/**
 * List of products selected by the user.
 */
public class Cart {

    //shirts only accessed by CartManager
    private List<Shirt> persistentShirts;

    public Cart() {
        this.persistentShirts = new ArrayList<>(10);
    }

    void addShirt(Shirt shirt) {
        persistentShirts.add(shirt);
    }

    Shirt getShirt(Shirt shirt) {
        int index = persistentShirts.indexOf(shirt);
        if (index != -1) {
            return persistentShirts.get(index);
        } else {
            return null;
        }
    }


    public List<Shirt> getShirts() {
        return new ArrayList<>(persistentShirts);
    }

    public void clearShirts() {
        persistentShirts.clear();
    }
}
