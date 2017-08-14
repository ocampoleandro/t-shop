package com.example.leandroocampo.t_shop.shop.presenter;

import com.example.leandroocampo.t_shop.common.model.Shirt;
import com.example.leandroocampo.t_shop.common.provider.BundleProvider;
import com.example.leandroocampo.t_shop.shop.view.DetailShirtView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.example.leandroocampo.t_shop.shop.presenter.DetailShirtPresenter.SHIRT_PARAM;
import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailShirtPresenterTest {

    private DetailShirtPresenter subject;

    private Shirt shirt;

    @Before
    public void setup() {
        shirt = new Shirt();
        shirt.setName("name");
        shirt.setPrice(20);
        shirt.setColour("blue");
        shirt.setSize("m");
        BundleProvider bundleProvider = Mockito.mock(BundleProvider.class);
        when(bundleProvider.getParcelable(eq(SHIRT_PARAM))).thenReturn(shirt);
        subject = new DetailShirtPresenter(bundleProvider);
    }

    @Test
    public void onShirtNeeded_shouldReturnShirt() {
        assertThat(subject.onShirtNeeded()).isEqualTo(shirt);
    }

    @Test
    public void onOutOfStock_showNoEnoughStockMessageShouldBeCalled() {
        DetailShirtView view = Mockito.mock(DetailShirtView.class);
        subject.onViewCreated(view);

        subject.outOfStock();
        verify(view).showNoEnoughStockMessage();
    }
}
