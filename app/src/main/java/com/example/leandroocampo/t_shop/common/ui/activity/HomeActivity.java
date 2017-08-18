package com.example.leandroocampo.t_shop.common.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.leandroocampo.t_shop.R;
import com.example.leandroocampo.t_shop.TShopApplication;
import com.example.leandroocampo.t_shop.common.presenter.HomePresenter;
import com.example.leandroocampo.t_shop.common.presenter.factory.HomePresenterFactory;
import com.example.leandroocampo.t_shop.common.presenter.factory.PresenterFactory;
import com.example.leandroocampo.t_shop.common.ui.FragmentChangeable;
import com.example.leandroocampo.t_shop.common.ui.TitleChangeable;
import com.example.leandroocampo.t_shop.common.ui.ToolbarChangeable;
import com.example.leandroocampo.t_shop.common.view.HomeView;
import com.example.leandroocampo.t_shop.shop.ui.fragment.ListShirtFragment;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity<HomePresenter, HomeView>
        implements TitleChangeable, ToolbarChangeable, HomeView, FragmentChangeable {

    private static final String FRAGMENT_ID = "MAIN_FRAGMENT";

    private Fragment fragmentContent = null;

    @Inject
    HomePresenterFactory presenterFactory;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            selectItem(item.getItemId());
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState != null) {
            //get saved fragment
            fragmentContent = getSupportFragmentManager().getFragment(savedInstanceState, FRAGMENT_ID);
        }
        if (fragmentContent != null) {
            updateMainFragment(fragmentContent);
        } else {
            //we did not have a fragment previously
            selectItem(R.id.navigation_shop);
        }
    }

    @NonNull
    @Override
    protected HomeView getMVPView() {
        return this;
    }


    private void selectItem(int itemId) {
        Fragment fragment;
        switch (itemId) {
            case R.id.navigation_shop:
                fragment = ListShirtFragment.newInstance();
                break;
            case R.id.navigation_dashboard:
                fragment = ListShirtFragment.newInstance();
                break;
            case R.id.navigation_notifications:
                fragment = ListShirtFragment.newInstance();
                break;
            default:
                fragment = ListShirtFragment.newInstance();
                break;
        }
        updateMainFragment(fragment);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Save the fragment's instance
        getSupportFragmentManager().putFragment(outState, FRAGMENT_ID, fragmentContent);
    }

    @NonNull
    @Override
    protected PresenterFactory<HomePresenter> getPresenterFactory() {
        return presenterFactory;
    }

    @Override
    protected void initInject() {
        TShopApplication.getInstance().getPresenterFactoryComponent().inject(this);
    }

    @Override
    public void setTitleToolbar(String title) {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }
    }

    @Override
    public void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
    }

    @Override
    public void updateMainFragment(Fragment fragment) {
        fragmentContent = fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_content, fragment)
                .commit();
    }
}
