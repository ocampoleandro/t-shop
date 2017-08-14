package com.example.leandroocampo.t_shop.shop.ui.fragment;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.leandroocampo.t_shop.BuildConfig;
import com.example.leandroocampo.t_shop.R;
import com.example.leandroocampo.t_shop.TShopTestApplication;
import com.example.leandroocampo.t_shop.common.model.Shirt;
import com.example.leandroocampo.t_shop.common.provider.ParamsProvider;
import com.example.leandroocampo.t_shop.configuration.injection.DaggerPresenterFactoryTestComponent;
import com.example.leandroocampo.t_shop.shop.presenter.ListShirtPresenter;
import com.example.leandroocampo.t_shop.shop.presenter.factory.ListShirtPresenterFactory;
import com.example.leandroocampo.t_shop.shop.ui.adapter.ShirtListAdapter;
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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;


@SuppressWarnings("ConstantConditions")
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, application = TShopTestApplication.class)
public class ListShirtFragmentTest {

    private ListShirtFragment subject;

    @Inject
    ListShirtPresenterFactory mockListShirtPresenterFactory;

    @Mock
    private ListShirtPresenter mockListShirtPresenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ((DaggerPresenterFactoryTestComponent) ((TShopTestApplication) RuntimeEnvironment.application).getInjector().getPresenterFactoryComponent()).inject(this);

        when(mockListShirtPresenterFactory.create((ParamsProvider) any())).thenReturn(mockListShirtPresenter);
        subject = ListShirtFragment.newInstance();
        startFragment(subject, GeneralActivity.class);
    }

    @Test
    public void onStart_shouldHaveTitle() {
        String title = ((AppCompatActivity) subject.getActivity()).getSupportActionBar().getTitle().toString();
        assertThat(title).isEqualTo("T-Shop");
    }

    @Test
    public void onStart_onShirtsRequestedShouldBeCalled() {
        View progressBar = subject.getView().findViewById(R.id.progress);
        View rvShirts = subject.getView().findViewById(R.id.rv_shirts);

        assertThat(progressBar.getVisibility()).isEqualTo(View.VISIBLE);
        assertThat(rvShirts.getVisibility()).isEqualTo(View.INVISIBLE);
        verify(mockListShirtPresenter).onShirtsRequested();
    }

    @Test
    public void onShowShirts_contentShouldBeVisible() {
        Shirt shirt1 = new Shirt();
        shirt1.setName("name");
        shirt1.setPrice(12);
        List<Shirt> shirtList = new ArrayList<>(1);
        shirtList.add(shirt1);

        subject.showShirts(shirtList);

        View progressBar = subject.getView().findViewById(R.id.progress);
        RecyclerView rvShirts = (RecyclerView) subject.getView().findViewById(R.id.rv_shirts);
        // workaround robolectric recyclerView issue
        rvShirts.measure(0, 0);
        rvShirts.layout(0, 0, 100, 1000);

        assertThat(progressBar.getVisibility()).isEqualTo(View.INVISIBLE);
        assertThat(rvShirts.getVisibility()).isEqualTo(View.VISIBLE);
        assertThat(rvShirts.getAdapter().getItemCount()).isEqualTo(1);

        ShirtListAdapter.ShirtViewHolder viewHolder = ((ShirtListAdapter.ShirtViewHolder) rvShirts
                .findViewHolderForAdapterPosition(0));
        assertThat(viewHolder.tvProductName.getText().toString()).isEqualTo(shirt1.getName());
        assertThat(viewHolder.tvProductPrice.getText().toString()).isEqualTo("$" + shirt1.getPrice());
    }

    @Test
    public void onShowErrorFetchingList_toastShouldBeShown() {
        subject.showErrorFetchingList();
        assertThat(ShadowToast.getTextOfLatestToast()).isEqualTo("Error fetching shirts");
    }

    @Test
    public void openShirtDetailScreen_shouldUpdateFragment() {
        Shirt shirt = new Shirt();
        shirt.setName("name");
        shirt.setPrice(20);
        shirt.setColour("blue");
        shirt.setSize("m");
        subject.openShirtDetailScreen(shirt);
        assertThat(((GeneralActivity) subject.getContext())
                .fragmentUpdated).isInstanceOf(DetailShirtFragment.class);
    }
}
