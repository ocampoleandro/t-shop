package com.example.leandroocampo.t_shop.shop.presenter;

import com.example.leandroocampo.t_shop.common.dao.RequestData;
import com.example.leandroocampo.t_shop.common.dao.ShirtDAO;
import com.example.leandroocampo.t_shop.common.dao.callback.ListCallback;
import com.example.leandroocampo.t_shop.common.model.Shirt;
import com.example.leandroocampo.t_shop.common.presenter.BasePresenter;
import com.example.leandroocampo.t_shop.configuration.DependencyInjector;
import com.example.leandroocampo.t_shop.shop.view.ListShirtView;

import java.util.List;

import javax.inject.Inject;

public class ListShirtPresenter extends BasePresenter<ListShirtView> implements ListCallback<Shirt> {

    @Inject
    ShirtDAO shirtDAO;

    private RequestData requestData;

    public ListShirtPresenter(ShirtDAO shirtDAO) {
        super(false);
        this.shirtDAO = shirtDAO;
    }

    public ListShirtPresenter() {
        super(true);
    }

    public void onShirtsRequested() {
        requestData = shirtDAO.listShirts(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (requestData != null && !requestData.isRequestCancelled()) requestData.cancelRequest();
    }

    @Override
    protected void initInject() {
        DependencyInjector.getInstance().getDaoComponent().inject(this);
    }

    @Override
    public void onSuccess(List<Shirt> shirts) {
        requestData = null;
        view.showShirts(shirts);
    }

    @Override
    public void onError() {
        view.showErrorFetchingList();
    }

    @Override
    public void onNoInternetConnection() {
        view.showErrorFetchingList();
    }

    RequestData getRequestData() {
        return requestData;
    }
}
