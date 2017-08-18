package com.example.leandroocampo.t_shop.common.model.cart;

import com.example.leandroocampo.t_shop.common.model.Shirt;

/**
 * Manager for {@link Cart}.
 */

public class CartManager {

    private Cart cart;

    public CartManager(Cart cart) {
        this.cart = cart;
    }

    public void addShirt(Shirt shirt, Listener listener) {
        if (shirt.getQuantity() == 0) {
            listener.outOfStock();
            return;
        }
        Shirt shirtInCart = cart.getShirt(shirt);
        if (shirtInCart == null) {
            cart.addShirt(new Shirt(shirt.getName(), shirt.getPrice(), shirt.getColour()
                    , 1, shirt.getSize(), shirt.getPicture()));
        } else {
            //check that more quantity than permitted is added
            if (shirtInCart.getQuantity() == shirt.getQuantity()) {
                listener.outOfStock();
                return;
            }
            shirtInCart.setQuantity(shirtInCart.getQuantity() + 1);
        }
    }

    public interface Listener {
        void outOfStock();
    }
}
