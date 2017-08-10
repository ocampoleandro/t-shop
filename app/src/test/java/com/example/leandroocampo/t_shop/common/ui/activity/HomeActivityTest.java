package com.example.leandroocampo.t_shop.common.ui.activity;

import android.support.v7.widget.Toolbar;

import com.example.leandroocampo.t_shop.BuildConfig;
import com.example.leandroocampo.t_shop.R;
import com.example.leandroocampo.t_shop.TShopTestApplication;
import com.example.leandroocampo.t_shop.common.presenter.HomePresenter;
import com.example.leandroocampo.t_shop.common.presenter.factory.HomePresenterFactory;
import com.example.leandroocampo.t_shop.common.provider.ParamsProvider;
import com.example.leandroocampo.t_shop.configuration.injection.DaggerPresenterFactoryTestComponent;
import com.example.leandroocampo.t_shop.shop.presenter.ListShirtPresenter;
import com.example.leandroocampo.t_shop.shop.presenter.factory.ListShirtPresenterFactory;
import com.example.leandroocampo.t_shop.shop.ui.fragment.ListShirtFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, application = TShopTestApplication.class)
public class HomeActivityTest {

    private HomeActivity subject;

    @Inject
    HomePresenterFactory mockHomePresenterFactory;
    @Inject
    ListShirtPresenterFactory mockListShirtPresenterFactory;

    private ActivityController<HomeActivity> controller;
    private HomePresenter mockHomePresenter;
    private ListShirtPresenter mockListShirtPresenter;

    @Before
    public void setup() {
        ((DaggerPresenterFactoryTestComponent) ((TShopTestApplication) RuntimeEnvironment.application).getInjector().getPresenterFactoryComponent()).inject(this);
        mockHomePresenter = mock(HomePresenter.class);
        mockListShirtPresenter = mock(ListShirtPresenter.class);

        when(mockHomePresenterFactory.create((ParamsProvider) any())).thenReturn(mockHomePresenter);
        when(mockListShirtPresenterFactory.create((ParamsProvider) any())).thenReturn(mockListShirtPresenter);

        controller = Robolectric.buildActivity(HomeActivity.class);
    }

    @Test
    public void onStart_presenterShouldNotBeNull() {
        subject = controller.create().start().get();
        assertThat(subject.getPresenter()).isNotNull();
    }

    @Test
    public void onResume_whenNoSavedInstanceState_listShirtFragmentShouldBeVisible() {
        subject = controller.create().start().resume().get();

        assertThat(subject.getSupportFragmentManager().findFragmentById(R.id.fragment_content)).isInstanceOf(ListShirtFragment.class);
        //noinspection ConstantConditions
        assertThat(subject.getSupportActionBar().getTitle()).isEqualTo("T-Shop");
    }

    @Test
    public void onSetToolbar_toolbarShouldBeInserted() {
        subject = controller.create().start().resume().get();
        subject.setToolbar(null);
        subject.setToolbar(new Toolbar(subject));
        assertThat(subject.getSupportActionBar()).isNotNull();
    }

    @Test
    public void onSetTitleToolbar_whenHasToolbar_toolbarShouldHaveTitle() {
        subject = controller.create().start().resume().get();
        subject.setToolbar(new Toolbar(subject));
        subject.setTitleToolbar("Test");
        //noinspection ConstantConditions
        assertThat(subject.getSupportActionBar().getTitle()).isEqualTo("Test");
    }
}
