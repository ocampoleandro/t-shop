package com.example.leandroocampo.t_shop.common.model.cart;

import com.example.leandroocampo.t_shop.common.model.Shirt;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CartManagerTest {

    private CartManager subject;

    @Mock
    private Cart mockCart;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        subject = new CartManager(mockCart);
    }

    @Test
    public void onAddShirt_shouldAddShirtToCart() {
        Shirt shirt = new Shirt();
        shirt.setName("name");
        shirt.setPrice(20);
        shirt.setColour("blue");
        shirt.setSize("m");
        shirt.setPicture("url");
        shirt.setQuantity(5);
        CartManager.Listener listener = Mockito.mock(CartManager.Listener.class);

        subject.addShirt(shirt, listener);
        verify(mockCart, times(1)).addShirt(eq(shirt));
    }

    @Test
    public void onAddShirt_whenThereIsNoStock_outOfStockShouldBeCalled() {
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
        verify(mockCart, never()).addShirt(eq(shirt));
    }

    @Test
    public void onAddShirt_whenExceedStock_outOfStockShouldBeCalled() {
        Shirt shirt = new Shirt();
        shirt.setName("name");
        shirt.setPrice(20);
        shirt.setColour("blue");
        shirt.setSize("m");
        shirt.setPicture("url");
        shirt.setQuantity(1);
        CartManager.Listener listener = Mockito.mock(CartManager.Listener.class);

        when(mockCart.getShirt(eq(shirt))).thenReturn(shirt);
        subject.addShirt(shirt, listener);

        verify(listener).outOfStock();
    }
}
