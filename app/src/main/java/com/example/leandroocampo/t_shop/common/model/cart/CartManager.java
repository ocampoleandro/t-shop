package com.example.leandroocampo.t_shop.common.model.cart;

import com.example.leandroocampo.t_shop.common.model.Shirt;

/**
 * Manager for {@link Cart}.
 */

public class CartManager {

    public void addShirt(Shirt shirt, Listener listener) {
        if (shirt.getQuantity() == 0) {
            listener.outOfStock();
            return;
        }
        Cart cart = Cart.getInstance();
        int index = cart.persistentShirts.indexOf(shirt);
        if (index == -1) {
            cart.persistentShirts.add(new Shirt(shirt.getName(), shirt.getPrice(), shirt.getColour()
                    , 1, shirt.getSize(), shirt.getPicture()));
        } else {
            Shirt shirtInCart = cart.persistentShirts.get(index);
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
