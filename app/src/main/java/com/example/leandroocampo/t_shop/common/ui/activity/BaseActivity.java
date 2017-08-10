package com.example.leandroocampo.t_shop.common.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.leandroocampo.t_shop.common.presenter.BasePresenter;
import com.example.leandroocampo.t_shop.common.presenter.factory.PresenterFactory;
import com.example.leandroocampo.t_shop.common.provider.IntentExtrasProvider;
import com.example.leandroocampo.t_shop.common.provider.ParamsProvider;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    //Presenter attached to Activity
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject();
        presenter = getPresenterFactory().create(new IntentExtrasProvider(savedInstanceState, getIntent()));
        //noinspection unchecked
        presenter.onViewCreated(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(new ParamsProvider(outState));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroyed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @NonNull
    protected abstract PresenterFactory<P> getPresenterFactory();

    /**
     * Initialize dependency injection in the component
     */
    protected abstract void initInject();
}
