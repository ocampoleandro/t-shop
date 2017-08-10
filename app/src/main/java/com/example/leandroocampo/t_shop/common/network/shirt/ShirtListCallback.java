package com.example.leandroocampo.t_shop.common.network.shirt;

import com.example.leandroocampo.t_shop.common.dao.callback.ListCallback;
import com.example.leandroocampo.t_shop.common.model.Shirt;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Callback for {@link List} of {@link Shirt}.
 */

public class ShirtListCallback implements Callback<List<Shirt>> {

    private ListCallback<Shirt> callback;

    public ShirtListCallback(ListCallback<Shirt> callback){
        this.callback = callback;
    }

    @Override
    public void onResponse(Call<List<Shirt>> call, Response<List<Shirt>> response) {
        if (response.isSuccessful()) {
            callback.onSuccess(response.body());
        } else {
            callback.onError();
        }
    }

    @Override
    public void onFailure(Call<List<Shirt>> call, Throwable t) {
        callback.onError();
    }
}
