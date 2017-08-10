package com.example.leandroocampo.t_shop.common.dao;

import com.example.leandroocampo.t_shop.common.dao.callback.ListCallback;
import com.example.leandroocampo.t_shop.common.model.Shirt;
import com.example.leandroocampo.t_shop.common.network.RequestDataNetwork;
import com.example.leandroocampo.t_shop.common.network.shirt.ShirtListCallback;
import com.example.leandroocampo.t_shop.common.network.shirt.ShirtNetClient;
import com.example.leandroocampo.t_shop.common.util.NetworkUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Access object for {@link Shirt}.
 */

public class ShirtDAO {

    private ShirtNetClient shirtNetClient;
    private NetworkUtil networkUtil;

    public ShirtDAO(ShirtNetClient shirtNetClient,NetworkUtil networkUtil){
        this.shirtNetClient = shirtNetClient;
        this.networkUtil = networkUtil;
    }

    public RequestData listShirts(ListCallback<Shirt> callback){
        if(networkUtil.testInternetConnection()){
            Call<List<Shirt>> call = shirtNetClient.getShirts();
            call.enqueue(new ShirtListCallback(callback));
            return new RequestDataNetwork(call);
        }else {
            callback.onNoInternetConnection();
            return null;
        }
    }
}
