package com.example.leandroocampo.t_shop.shop.ui.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.leandroocampo.t_shop.BuildConfig;
import com.example.leandroocampo.t_shop.R;
import com.example.leandroocampo.t_shop.TShopTestApplication;
import com.example.leandroocampo.t_shop.common.model.Shirt;
import com.example.leandroocampo.t_shop.common.provider.ParamsProvider;
import com.example.leandroocampo.t_shop.configuration.injection.DaggerPresenterFactoryTestComponent;
import com.example.leandroocampo.t_shop.shop.presenter.DetailShirtPresenter;
import com.example.leandroocampo.t_shop.shop.presenter.factory.DetailShirtPresenterFactory;
import com.example.leandroocampo.t_shop.test_util.GeneralActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import javax.inject.Inject;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, application = TShopTestApplication.class)
public class DetailShirtFragmentTest {

    private DetailShirtFragment subject;

    @Inject
    DetailShirtPresenterFactory mockPresenterFactory;

    @Mock
    DetailShirtPresenter mockDetailShirtPresenter;

    private Shirt shirt;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ((DaggerPresenterFactoryTestComponent) ((TShopTestApplication) RuntimeEnvironment.application).getPresenterFactoryComponent()).inject(this);

        shirt = new Shirt();
        shirt.setName("name");
        shirt.setPrice(20);
        shirt.setColour("blue");
        shirt.setSize("m");
        subject = DetailShirtFragment.newInstance(shirt);

        when(mockPresenterFactory.create((ParamsProvider) any())).thenReturn(mockDetailShirtPresenter);
        when(mockDetailShirtPresenter.onShirtNeeded()).thenReturn(shirt);

        startFragment(subject, GeneralActivity.class);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void onStart_shouldShowShirtDetails() {
        View view = subject.getView();
        TextView tvProductName = (TextView) view.findViewById(R.id.tv_product_name);
        TextView tvProductPrice = (TextView) view.findViewById(R.id.tv_product_price);
        TextView tvColour = (TextView) view.findViewById(R.id.tv_colour);
        TextView tvSize = (TextView) view.findViewById(R.id.tv_size);

        assertThat(tvProductName.getText().toString()).isEqualTo(shirt.getName());
        assertThat(tvProductPrice.getText().toString()).isEqualTo("$" + shirt.getPrice());
        assertThat(tvColour.getText().toString()).isEqualTo(shirt.getColour());
        assertThat(tvSize.getText().toString()).isEqualTo(shirt.getSize());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void onStart_shouldHaveNoTitle() {
        String title = ((AppCompatActivity) subject.getActivity()).getSupportActionBar().getTitle().toString();
        assertThat(title).isEqualTo("");
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void onFabAddCartClicked_onShirtAddedToCartShouldBeCalled() {
        View view = subject.getView();
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_add_cart);

        fab.performClick();
        verify(mockDetailShirtPresenter).onShirtAddedToCart();
    }

    @Test
    public void onShowNoEnoughStock_toastShouldBeShown() {
        subject.showNoEnoughStockMessage();
        assertThat(ShadowToast.getTextOfLatestToast()).isEqualTo("No enough stock");
    }
}
