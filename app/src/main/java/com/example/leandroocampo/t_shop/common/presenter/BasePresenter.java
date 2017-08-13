package com.example.leandroocampo.t_shop.common.presenter;

import com.example.leandroocampo.t_shop.common.provider.ParamsProvider;

public abstract class BasePresenter<T> {

    //Activity or Fragment attached to Presenter
    protected T view;

    public BasePresenter(boolean inject) {
        if(inject) initInject();
    }

    public void onViewCreated(T view) {
        this.view = view;
    }

    public void onStart() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStop(){

    }

    public void onDestroyed() {

    }

    /**
     * Initialize dependency injection in the component
     */
    protected abstract void initInject();

    public void onSaveInstanceState(ParamsProvider bundleProvider) {

    }

    public T getView() {
        return view;
    }
}
