package com.example.leandroocampo.t_shop.common.model.cart;

import com.example.leandroocampo.t_shop.common.model.Shirt;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.verify;

public class CartManagerTest {

    private CartManager subject;

    @Before
    public void setup() {
        subject = new CartManager();
    }

    @Test
    public void onAddShirt_shouldAddShirtToCart() {
        Cart.getInstance().clearShirts();
        Shirt shirt = new Shirt();
        shirt.setName("name");
        shirt.setPrice(20);
        shirt.setColour("blue");
        shirt.setSize("m");
        shirt.setPicture("url");
        shirt.setQuantity(5);
        CartManager.Listener listener = Mockito.mock(CartManager.Listener.class);

        subject.addShirt(shirt, listener);
        assertThat(Cart.getInstance().persistentShirts.contains(shirt)).isTrue();

        int index = Cart.getInstance().getShirts().indexOf(shirt);
        assertThat(Cart.getInstance().getShirts().get(index).getQuantity()).isEqualTo(1);
    }

    @Test
    public void onAddShirt_whenThereIsNoStock_outOfStockShouldBeCalled() {
        Cart.getInstance().clearShirts();
        Shirt shirt = new Shirt();
        shirt.setName("name");
        shirt.setPrice(20);
        shirt.setColour("blue");
        shirt.setSize("m");
        shirt.setPicture("url");
        shirt.setQuantity(0);
        CartManager.Listener listener = Mockito.mock(CartManager.Listener.class);

        subject.addShirt(shirt, listener);
        verify(listener).outOfStock();
        assertThat(Cart.getInstance().getShirts().indexOf(shirt)).isEqualTo(-1);
    }

    @Test
    public void onAddShirt_whenExceedStock_outOfStockShouldBeCalled() {
        Cart.getInstance().clearShirts();
        Shirt shirt = new Shirt();
        shirt.setName("name");
        shirt.setPrice(20);
        shirt.setColour("blue");
        shirt.setSize("m");
        shirt.setPicture("url");
        shirt.setQuantity(1);
        CartManager.Listener listener = Mockito.mock(CartManager.Listener.class);

        subject.addShirt(shirt, listener);
        subject.addShirt(shirt, listener);
        verify(listener).outOfStock();

        int index = Cart.getInstance().getShirts().indexOf(shirt);
        assertThat(Cart.getInstance().getShirts().get(index).getQuantity()).isEqualTo(1);
    }
}
