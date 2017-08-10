package com.example.leandroocampo.t_shop.common.network;

import com.example.leandroocampo.t_shop.common.dao.RequestData;

import retrofit2.Call;

/**
 * Represents a network request.
 */

public class RequestDataNetwork implements RequestData {

    private Call request;

    public RequestDataNetwork(Call request) {
        this.request = request;
    }

    @Override
    public void cancelRequest() {
        this.request.cancel();
    }

    @Override
    public boolean isRequestCancelled() {
        return request.isCanceled();
    }
}
