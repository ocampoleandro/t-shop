package com.example.leandroocampo.t_shop.common.presenter;

import com.example.leandroocampo.t_shop.common.provider.ParamsProvider;

public abstract class BasePresenter<T> {

    //Activity or Fragment attached to Presenter
    protected T view;

    BasePresenter() {
        initInject();
    }

    public void onViewCreated(T view) {
        this.view = view;
    }

    public void onStart() {

    }

    public void onDestroyed() {

    }

    /**
     * Initialize dependency injection in the component
     */
    protected abstract void initInject();

    public void onSaveInstanceState(ParamsProvider bundleProvider) {

    }

}
