package com.example.leandroocampo.t_shop.shop.presenter;

import com.example.leandroocampo.t_shop.common.dao.RequestData;
import com.example.leandroocampo.t_shop.common.dao.ShirtDAO;
import com.example.leandroocampo.t_shop.common.dao.callback.ListCallback;
import com.example.leandroocampo.t_shop.common.model.Shirt;
import com.example.leandroocampo.t_shop.common.presenter.BasePresenter;
import com.example.leandroocampo.t_shop.shop.ui.adapter.ShirtListAdapter;
import com.example.leandroocampo.t_shop.shop.view.ListShirtView;

import java.util.List;

public class ListShirtPresenter extends BasePresenter<ListShirtView> implements ListCallback<Shirt>, ShirtListAdapter.InteractionListener {

    private ShirtDAO shirtDAO;

    private RequestData requestData;

    public ListShirtPresenter(ShirtDAO shirtDAO) {
        this.shirtDAO = shirtDAO;
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

    @Override
    public void onItemClicked(Shirt shirt) {
        view.openShirtDetailScreen(shirt);
    }
}
