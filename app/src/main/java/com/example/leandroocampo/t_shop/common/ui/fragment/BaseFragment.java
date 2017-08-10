package com.example.leandroocampo.t_shop.common.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.leandroocampo.t_shop.common.presenter.BasePresenter;
import com.example.leandroocampo.t_shop.common.presenter.factory.PresenterFactory;
import com.example.leandroocampo.t_shop.common.provider.BundleProvider;
import com.example.leandroocampo.t_shop.common.provider.ParamsProvider;

public abstract class BaseFragment<P extends BasePresenter<V>,V> extends Fragment{

    //Presenter attached to Fragment
    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject();
        presenter = getPresenterFactory().create(new BundleProvider(savedInstanceState, getArguments()));
        //noinspection unchecked
        presenter.onViewCreated(getMVPView());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(new ParamsProvider(outState));
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroyed();
    }

    /**
     * Return the view that will be attached to the {@link BasePresenter}
     * @return A view interface
     */
    @NonNull
    protected abstract V getMVPView();

    /**
     * Return a factory of a specific {@link BasePresenter}
     * @return an implementation of {@link PresenterFactory}
     */
    @NonNull
    protected abstract PresenterFactory<P> getPresenterFactory();

    /**
     * Initialize dependency injection in the component
     */
    protected abstract void initInject();
}
